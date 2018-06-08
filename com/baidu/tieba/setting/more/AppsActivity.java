package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.h;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView gtV = null;
    private a gtW = null;
    private LinearLayout gtX = null;
    private ProgressBar gtY = null;
    private ImageView gtZ = null;
    private RelativeLayout mParent = null;
    private RelativeLayout gua = null;
    private TextView mTitleText = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.app_activity);
        Qg();
        C(bundle);
    }

    private void C(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!bqp()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.gtW != null) {
            this.gtW.cancel();
        }
        this.gtW = new a(this.mUrl);
        this.gtW.setPriority(3);
        this.gtW.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.e(this.mParent, i);
        al.e(this.mWebView, i);
        al.g(this.gua, i);
        al.a(this.gtV, i);
        al.c(this.mTitleText, i);
        al.b(this.gtZ, i);
    }

    private void Qg() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.gua = (RelativeLayout) findViewById(d.g.title);
        this.mTitleText = (TextView) findViewById(d.g.title_text);
        this.mWebView = (BaseWebView) findViewById(d.g.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.gtY = (ProgressBar) findViewById(d.g.app_progress);
        this.gtX = (LinearLayout) findViewById(d.g.webview_fail_imageview);
        this.gtX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.gtZ = (ImageView) findViewById(d.g.refresh);
        this.gtZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.gtV = (ImageView) findViewById(d.g.back);
        this.gtV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private y mNetWork = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.gtY.setVisibility(0);
            AppsActivity.this.gtX.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            if (this.url == null) {
                return null;
            }
            this.mNetWork = new y(this.url);
            this.mNetWork.yJ().zI().zL().asn = false;
            this.mNetWork.o("client", HttpConstants.OS_TYPE_VALUE);
            return this.mNetWork.yl();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            AppsActivity.this.gtY.setVisibility(8);
            AppsActivity.this.gtW = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(final String str) {
            AppsActivity.this.gtY.setVisibility(8);
            if (this.mNetWork != null && this.mNetWork.yM() && str != null && str.length() > 0) {
                h.in().d(new Runnable() { // from class: com.baidu.tieba.setting.more.AppsActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkCoreApplication.getInst().cashNoAccountData(str, 7);
                    }
                });
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", IoUtils.UTF_8, "");
            } else if (!AppsActivity.this.bqp() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.gtX.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(d.k.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(d.k.server_404), "text/html", IoUtils.UTF_8, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqp() {
        String noAccountData = TbadkCoreApplication.getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.gtY.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", IoUtils.UTF_8, "");
        return true;
    }
}
