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
    private ImageView cOi = null;
    private a cOj = null;
    private LinearLayout cOk = null;
    private ProgressBar cOl = null;
    private ImageView cOm = null;
    private RelativeLayout brS = null;
    private RelativeLayout cOn = null;
    private TextView LO = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.app_activity);
        FL();
        k(bundle);
    }

    private void k(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.tu().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!asb()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.cOj != null) {
            this.cOj.cancel();
        }
        this.cOj = new a(this.mUrl);
        this.cOj.setPriority(3);
        this.cOj.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.an.e(this.brS, i);
        com.baidu.tbadk.core.util.an.e(this.mWebView, i);
        com.baidu.tbadk.core.util.an.g(this.cOn, i);
        com.baidu.tbadk.core.util.an.a(this.cOi, i);
        com.baidu.tbadk.core.util.an.e(this.LO, i);
        com.baidu.tbadk.core.util.an.b(this.cOm, i);
    }

    private void FL() {
        this.brS = (RelativeLayout) findViewById(i.f.parent);
        this.cOn = (RelativeLayout) findViewById(i.f.title);
        this.LO = (TextView) findViewById(i.f.title_text);
        this.mWebView = (BaseWebView) findViewById(i.f.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.cOl = (ProgressBar) findViewById(i.f.app_progress);
        this.cOk = (LinearLayout) findViewById(i.f.webview_fail_imageview);
        this.cOk.setOnClickListener(new h(this));
        this.cOm = (ImageView) findViewById(i.f.refresh);
        this.cOm.setOnClickListener(new i(this));
        this.cOi = (ImageView) findViewById(i.f.back);
        this.cOi.setOnClickListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private com.baidu.tbadk.core.util.w Tj = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.cOl.setVisibility(0);
            AppsActivity.this.cOk.setVisibility(8);
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
            this.Tj = new com.baidu.tbadk.core.util.w(this.url);
            this.Tj.uh().uZ().vc().acr = false;
            this.Tj.o("client", SocialConstants.ANDROID_CLIENT_TYPE);
            return this.Tj.tG();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Tj != null) {
                this.Tj.gJ();
            }
            AppsActivity.this.cOl.setVisibility(8);
            AppsActivity.this.cOj = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            AppsActivity.this.cOl.setVisibility(8);
            if (this.Tj != null && this.Tj.uk() && str != null && str.length() > 0) {
                com.baidu.adp.lib.g.k.hi().c(new k(this, str));
                com.baidu.tbadk.core.sharedPref.b.tu().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.asb() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.cOk.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(i.h.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(i.h.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asb() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.cOl.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
