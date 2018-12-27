package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView gZi = null;
    private a gZj = null;
    private LinearLayout gZk = null;
    private ProgressBar gZl = null;
    private ImageView gZm = null;
    private RelativeLayout mParent = null;
    private RelativeLayout gZn = null;
    private TextView dwu = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.app_activity);
        VQ();
        J(bundle);
    }

    private void J(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!bxy()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.gZj != null) {
            this.gZj.cancel();
        }
        this.gZj = new a(this.mUrl);
        this.gZj.setPriority(3);
        this.gZj.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.e(this.mParent, i);
        al.e(this.mWebView, i);
        al.g(this.gZn, i);
        al.a(this.gZi, i);
        al.c(this.dwu, i);
        al.b(this.gZm, i);
    }

    private void VQ() {
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.gZn = (RelativeLayout) findViewById(e.g.title);
        this.dwu = (TextView) findViewById(e.g.title_text);
        this.mWebView = (BaseWebView) findViewById(e.g.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.gZl = (ProgressBar) findViewById(e.g.app_progress);
        this.gZk = (LinearLayout) findViewById(e.g.webview_fail_imageview);
        this.gZk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.gZm = (ImageView) findViewById(e.g.refresh);
        this.gZm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.gZi = (ImageView) findViewById(e.g.back);
        this.gZi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private x mNetWork = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.gZl.setVisibility(0);
            AppsActivity.this.gZk.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            if (this.url == null) {
                return null;
            }
            this.mNetWork = new x(this.url);
            this.mNetWork.Dj().Eh().Ek().aDT = false;
            this.mNetWork.x("client", HttpConstants.OS_TYPE_VALUE);
            return this.mNetWork.CL();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            AppsActivity.this.gZl.setVisibility(8);
            AppsActivity.this.gZj = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(final String str) {
            AppsActivity.this.gZl.setVisibility(8);
            if (this.mNetWork != null && this.mNetWork.Dm() && str != null && str.length() > 0) {
                com.baidu.adp.lib.g.h.jH().d(new Runnable() { // from class: com.baidu.tieba.setting.more.AppsActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkCoreApplication.getInst().cashNoAccountData(str, 7);
                    }
                });
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", IoUtils.UTF_8, "");
            } else if (!AppsActivity.this.bxy() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.gZk.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(e.j.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(e.j.server_404), "text/html", IoUtils.UTF_8, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bxy() {
        String noAccountData = TbadkCoreApplication.getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.gZl.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", IoUtils.UTF_8, "");
        return true;
    }
}
