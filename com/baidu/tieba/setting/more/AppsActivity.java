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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView gyV = null;
    private a gyW = null;
    private LinearLayout gyX = null;
    private ProgressBar gyY = null;
    private ImageView gyZ = null;
    private RelativeLayout mParent = null;
    private RelativeLayout gza = null;
    private TextView cYc = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.app_activity);
        QK();
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
        } else if (!bpt()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.gyW != null) {
            this.gyW.cancel();
        }
        this.gyW = new a(this.mUrl);
        this.gyW.setPriority(3);
        this.gyW.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.e(this.mParent, i);
        am.e(this.mWebView, i);
        am.g(this.gza, i);
        am.a(this.gyV, i);
        am.c(this.cYc, i);
        am.b(this.gyZ, i);
    }

    private void QK() {
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.gza = (RelativeLayout) findViewById(d.g.title);
        this.cYc = (TextView) findViewById(d.g.title_text);
        this.mWebView = (BaseWebView) findViewById(d.g.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.gyY = (ProgressBar) findViewById(d.g.app_progress);
        this.gyX = (LinearLayout) findViewById(d.g.webview_fail_imageview);
        this.gyX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.gyZ = (ImageView) findViewById(d.g.refresh);
        this.gyZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.gyV = (ImageView) findViewById(d.g.back);
        this.gyV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.3
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
            AppsActivity.this.gyY.setVisibility(0);
            AppsActivity.this.gyX.setVisibility(8);
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
            this.mNetWork.yO().zM().zP().ast = false;
            this.mNetWork.o("client", HttpConstants.OS_TYPE_VALUE);
            return this.mNetWork.yq();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            AppsActivity.this.gyY.setVisibility(8);
            AppsActivity.this.gyW = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(final String str) {
            AppsActivity.this.gyY.setVisibility(8);
            if (this.mNetWork != null && this.mNetWork.yR() && str != null && str.length() > 0) {
                h.io().d(new Runnable() { // from class: com.baidu.tieba.setting.more.AppsActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkCoreApplication.getInst().cashNoAccountData(str, 7);
                    }
                });
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", IoUtils.UTF_8, "");
            } else if (!AppsActivity.this.bpt() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.gyX.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(d.j.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(d.j.server_404), "text/html", IoUtils.UTF_8, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpt() {
        String noAccountData = TbadkCoreApplication.getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.gyY.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", IoUtils.UTF_8, "");
        return true;
    }
}
