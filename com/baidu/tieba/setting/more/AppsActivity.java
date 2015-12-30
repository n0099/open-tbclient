package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView dtL = null;
    private a dtM = null;
    private LinearLayout dtN = null;
    private ProgressBar dtO = null;
    private ImageView dtP = null;
    private RelativeLayout bKF = null;
    private RelativeLayout dtQ = null;
    private TextView Mv = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.app_activity);
        GH();
        h(bundle);
    }

    private void h(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.tJ().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!azF()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.dtM != null) {
            this.dtM.cancel();
        }
        this.dtM = new a(this.mUrl);
        this.dtM.setPriority(3);
        this.dtM.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.as.e(this.bKF, i);
        com.baidu.tbadk.core.util.as.e(this.mWebView, i);
        com.baidu.tbadk.core.util.as.g(this.dtQ, i);
        com.baidu.tbadk.core.util.as.a(this.dtL, i);
        com.baidu.tbadk.core.util.as.e(this.Mv, i);
        com.baidu.tbadk.core.util.as.b(this.dtP, i);
    }

    private void GH() {
        this.bKF = (RelativeLayout) findViewById(n.g.parent);
        this.dtQ = (RelativeLayout) findViewById(n.g.title);
        this.Mv = (TextView) findViewById(n.g.title_text);
        this.mWebView = (BaseWebView) findViewById(n.g.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.dtO = (ProgressBar) findViewById(n.g.app_progress);
        this.dtN = (LinearLayout) findViewById(n.g.webview_fail_imageview);
        this.dtN.setOnClickListener(new h(this));
        this.dtP = (ImageView) findViewById(n.g.refresh);
        this.dtP.setOnClickListener(new i(this));
        this.dtL = (ImageView) findViewById(n.g.back);
        this.dtL.setOnClickListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private com.baidu.tbadk.core.util.ab Ua = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.dtO.setVisibility(0);
            AppsActivity.this.dtN.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: t */
        public String doInBackground(Object... objArr) {
            if (this.url == null) {
                return null;
            }
            this.Ua = new com.baidu.tbadk.core.util.ab(this.url);
            this.Ua.uw().vp().vs().adO = false;
            this.Ua.o("client", SocialConstants.ANDROID_CLIENT_TYPE);
            return this.Ua.tV();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Ua != null) {
                this.Ua.gL();
            }
            AppsActivity.this.dtO.setVisibility(8);
            AppsActivity.this.dtM = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            AppsActivity.this.dtO.setVisibility(8);
            if (this.Ua != null && this.Ua.uz() && str != null && str.length() > 0) {
                com.baidu.adp.lib.h.k.hk().c(new k(this, str));
                com.baidu.tbadk.core.sharedPref.b.tJ().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.azF() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.dtN.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(n.j.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(n.j.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azF() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.dtO.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
