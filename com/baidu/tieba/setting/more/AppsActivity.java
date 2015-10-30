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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView cMM = null;
    private a cMN = null;
    private LinearLayout cMO = null;
    private ProgressBar cMP = null;
    private ImageView cMQ = null;
    private RelativeLayout bro = null;
    private RelativeLayout cMR = null;
    private TextView LN = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.app_activity);
        FO();
        k(bundle);
    }

    private void k(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.tr().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!arv()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.cMN != null) {
            this.cMN.cancel();
        }
        this.cMN = new a(this.mUrl);
        this.cMN.setPriority(3);
        this.cMN.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.an.e(this.bro, i);
        com.baidu.tbadk.core.util.an.e(this.mWebView, i);
        com.baidu.tbadk.core.util.an.g(this.cMR, i);
        com.baidu.tbadk.core.util.an.a(this.cMM, i);
        com.baidu.tbadk.core.util.an.e(this.LN, i);
        com.baidu.tbadk.core.util.an.b(this.cMQ, i);
    }

    private void FO() {
        this.bro = (RelativeLayout) findViewById(i.f.parent);
        this.cMR = (RelativeLayout) findViewById(i.f.title);
        this.LN = (TextView) findViewById(i.f.title_text);
        this.mWebView = (BaseWebView) findViewById(i.f.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.cMP = (ProgressBar) findViewById(i.f.app_progress);
        this.cMO = (LinearLayout) findViewById(i.f.webview_fail_imageview);
        this.cMO.setOnClickListener(new h(this));
        this.cMQ = (ImageView) findViewById(i.f.refresh);
        this.cMQ.setOnClickListener(new i(this));
        this.cMM = (ImageView) findViewById(i.f.back);
        this.cMM.setOnClickListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private com.baidu.tbadk.core.util.w Ti = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.cMP.setVisibility(0);
            AppsActivity.this.cMO.setVisibility(8);
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
            this.Ti = new com.baidu.tbadk.core.util.w(this.url);
            this.Ti.ue().uV().uY().acm = false;
            this.Ti.o("client", SocialConstants.ANDROID_CLIENT_TYPE);
            return this.Ti.tD();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Ti != null) {
                this.Ti.gJ();
            }
            AppsActivity.this.cMP.setVisibility(8);
            AppsActivity.this.cMN = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            AppsActivity.this.cMP.setVisibility(8);
            if (this.Ti != null && this.Ti.uh() && str != null && str.length() > 0) {
                com.baidu.adp.lib.g.k.hh().c(new k(this, str));
                com.baidu.tbadk.core.sharedPref.b.tr().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.arv() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.cMO.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(i.h.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(i.h.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arv() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.cMP.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
