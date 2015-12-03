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
    private ImageView dmz = null;
    private a dmA = null;
    private LinearLayout dmB = null;
    private ProgressBar dmC = null;
    private ImageView dmD = null;
    private RelativeLayout bGY = null;
    private RelativeLayout dmE = null;
    private TextView Mf = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.app_activity);
        GS();
        l(bundle);
    }

    private void l(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.tZ().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!axz()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.dmA != null) {
            this.dmA.cancel();
        }
        this.dmA = new a(this.mUrl);
        this.dmA.setPriority(3);
        this.dmA.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.as.e(this.bGY, i);
        com.baidu.tbadk.core.util.as.e(this.mWebView, i);
        com.baidu.tbadk.core.util.as.g(this.dmE, i);
        com.baidu.tbadk.core.util.as.a(this.dmz, i);
        com.baidu.tbadk.core.util.as.e(this.Mf, i);
        com.baidu.tbadk.core.util.as.b(this.dmD, i);
    }

    private void GS() {
        this.bGY = (RelativeLayout) findViewById(n.f.parent);
        this.dmE = (RelativeLayout) findViewById(n.f.title);
        this.Mf = (TextView) findViewById(n.f.title_text);
        this.mWebView = (BaseWebView) findViewById(n.f.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.dmC = (ProgressBar) findViewById(n.f.app_progress);
        this.dmB = (LinearLayout) findViewById(n.f.webview_fail_imageview);
        this.dmB.setOnClickListener(new h(this));
        this.dmD = (ImageView) findViewById(n.f.refresh);
        this.dmD.setOnClickListener(new i(this));
        this.dmz = (ImageView) findViewById(n.f.back);
        this.dmz.setOnClickListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private com.baidu.tbadk.core.util.ab Ty = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.dmC.setVisibility(0);
            AppsActivity.this.dmB.setVisibility(8);
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
            this.Ty = new com.baidu.tbadk.core.util.ab(this.url);
            this.Ty.uM().vF().vI().adk = false;
            this.Ty.o("client", SocialConstants.ANDROID_CLIENT_TYPE);
            return this.Ty.ul();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Ty != null) {
                this.Ty.gL();
            }
            AppsActivity.this.dmC.setVisibility(8);
            AppsActivity.this.dmA = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            AppsActivity.this.dmC.setVisibility(8);
            if (this.Ty != null && this.Ty.uP() && str != null && str.length() > 0) {
                com.baidu.adp.lib.h.k.hk().c(new k(this, str));
                com.baidu.tbadk.core.sharedPref.b.tZ().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.axz() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.dmB.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(n.i.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(n.i.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean axz() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.dmC.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
