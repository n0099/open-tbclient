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
    private ImageView dJP = null;
    private a dJQ = null;
    private LinearLayout dJR = null;
    private ProgressBar dJS = null;
    private ImageView dJT = null;
    private RelativeLayout bOs = null;
    private RelativeLayout dJU = null;
    private TextView ML = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.app_activity);
        Ii();
        o(bundle);
    }

    private void o(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.uO().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!aGM()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.dJQ != null) {
            this.dJQ.cancel();
        }
        this.dJQ = new a(this.mUrl);
        this.dJQ.setPriority(3);
        this.dJQ.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ar.g(this.bOs, i);
        com.baidu.tbadk.core.util.ar.g(this.mWebView, i);
        com.baidu.tbadk.core.util.ar.i(this.dJU, i);
        com.baidu.tbadk.core.util.ar.a(this.dJP, i);
        com.baidu.tbadk.core.util.ar.e(this.ML, i);
        com.baidu.tbadk.core.util.ar.b(this.dJT, i);
    }

    private void Ii() {
        this.bOs = (RelativeLayout) findViewById(t.g.parent);
        this.dJU = (RelativeLayout) findViewById(t.g.title);
        this.ML = (TextView) findViewById(t.g.title_text);
        this.mWebView = (BaseWebView) findViewById(t.g.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.dJS = (ProgressBar) findViewById(t.g.app_progress);
        this.dJR = (LinearLayout) findViewById(t.g.webview_fail_imageview);
        this.dJR.setOnClickListener(new h(this));
        this.dJT = (ImageView) findViewById(t.g.refresh);
        this.dJT.setOnClickListener(new i(this));
        this.dJP = (ImageView) findViewById(t.g.back);
        this.dJP.setOnClickListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private com.baidu.tbadk.core.util.aa Ty = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.dJS.setVisibility(0);
            AppsActivity.this.dJR.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public String doInBackground(Object... objArr) {
            if (this.url == null) {
                return null;
            }
            this.Ty = new com.baidu.tbadk.core.util.aa(this.url);
            this.Ty.vB().wv().wy().aeo = false;
            this.Ty.p("client", SocialConstants.ANDROID_CLIENT_TYPE);
            return this.Ty.uZ();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Ty != null) {
                this.Ty.gT();
            }
            AppsActivity.this.dJS.setVisibility(8);
            AppsActivity.this.dJQ = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ek */
        public void onPostExecute(String str) {
            AppsActivity.this.dJS.setVisibility(8);
            if (this.Ty != null && this.Ty.vE() && str != null && str.length() > 0) {
                com.baidu.adp.lib.h.k.hs().c(new k(this, str));
                com.baidu.tbadk.core.sharedPref.b.uO().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.aGM() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.dJR.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(t.j.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(t.j.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aGM() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.dJS.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
