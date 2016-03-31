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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView ecj = null;
    private a eck = null;
    private LinearLayout ecl = null;
    private ProgressBar ecm = null;
    private ImageView ecn = null;
    private RelativeLayout bYK = null;
    private RelativeLayout eco = null;
    private TextView MR = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.app_activity);
        JE();
        q(bundle);
    }

    private void q(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.vk().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!aNw()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.eck != null) {
            this.eck.cancel();
        }
        this.eck = new a(this.mUrl);
        this.eck.setPriority(3);
        this.eck.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.at.g(this.bYK, i);
        com.baidu.tbadk.core.util.at.g(this.mWebView, i);
        com.baidu.tbadk.core.util.at.i(this.eco, i);
        com.baidu.tbadk.core.util.at.a(this.ecj, i);
        com.baidu.tbadk.core.util.at.e(this.MR, i);
        com.baidu.tbadk.core.util.at.b(this.ecn, i);
    }

    private void JE() {
        this.bYK = (RelativeLayout) findViewById(t.g.parent);
        this.eco = (RelativeLayout) findViewById(t.g.title);
        this.MR = (TextView) findViewById(t.g.title_text);
        this.mWebView = (BaseWebView) findViewById(t.g.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.ecm = (ProgressBar) findViewById(t.g.app_progress);
        this.ecl = (LinearLayout) findViewById(t.g.webview_fail_imageview);
        this.ecl.setOnClickListener(new h(this));
        this.ecn = (ImageView) findViewById(t.g.refresh);
        this.ecn.setOnClickListener(new i(this));
        this.ecj = (ImageView) findViewById(t.g.back);
        this.ecj.setOnClickListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private com.baidu.tbadk.core.util.ab QV = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.ecm.setVisibility(0);
            AppsActivity.this.ecl.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public String doInBackground(Object... objArr) {
            if (this.url == null) {
                return null;
            }
            this.QV = new com.baidu.tbadk.core.util.ab(this.url);
            this.QV.vU().wO().wR().adE = false;
            this.QV.p("client", SocialConstants.ANDROID_CLIENT_TYPE);
            return this.QV.vw();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.QV != null) {
                this.QV.gX();
            }
            AppsActivity.this.ecm.setVisibility(8);
            AppsActivity.this.eck = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            AppsActivity.this.ecm.setVisibility(8);
            if (this.QV != null && this.QV.vX() && str != null && str.length() > 0) {
                com.baidu.adp.lib.h.k.hy().c(new k(this, str));
                com.baidu.tbadk.core.sharedPref.b.vk().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.aNw() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.ecl.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(t.j.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(t.j.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aNw() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.ecm.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
