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
    private ImageView cwP = null;
    private a cwQ = null;
    private LinearLayout cwR = null;
    private ProgressBar cwS = null;
    private ImageView cwT = null;
    private RelativeLayout bnG = null;
    private RelativeLayout cwU = null;
    private TextView LM = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.app_activity);
        FO();
        j(bundle);
    }

    private void j(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.ts().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!akU()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.cwQ != null) {
            this.cwQ.cancel();
        }
        this.cwQ = new a(this.mUrl);
        this.cwQ.setPriority(3);
        this.cwQ.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.e(this.bnG, i);
        com.baidu.tbadk.core.util.al.e(this.mWebView, i);
        com.baidu.tbadk.core.util.al.h(this.cwU, i);
        com.baidu.tbadk.core.util.al.a(this.cwP, i);
        com.baidu.tbadk.core.util.al.e(this.LM, i);
        com.baidu.tbadk.core.util.al.b(this.cwT, i);
    }

    private void FO() {
        this.bnG = (RelativeLayout) findViewById(i.f.parent);
        this.cwU = (RelativeLayout) findViewById(i.f.title);
        this.LM = (TextView) findViewById(i.f.title_text);
        this.mWebView = (BaseWebView) findViewById(i.f.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.cwS = (ProgressBar) findViewById(i.f.app_progress);
        this.cwR = (LinearLayout) findViewById(i.f.webview_fail_imageview);
        this.cwR.setOnClickListener(new h(this));
        this.cwT = (ImageView) findViewById(i.f.refresh);
        this.cwT.setOnClickListener(new i(this));
        this.cwP = (ImageView) findViewById(i.f.back);
        this.cwP.setOnClickListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private com.baidu.tbadk.core.util.v Tu = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.cwS.setVisibility(0);
            AppsActivity.this.cwR.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: u */
        public String doInBackground(Object... objArr) {
            if (this.url == null) {
                return null;
            }
            this.Tu = new com.baidu.tbadk.core.util.v(this.url);
            this.Tu.ue().uV().uY().acc = false;
            this.Tu.o("client", SocialConstants.ANDROID_CLIENT_TYPE);
            return this.Tu.tD();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Tu != null) {
                this.Tu.gM();
            }
            AppsActivity.this.cwS.setVisibility(8);
            AppsActivity.this.cwQ = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            AppsActivity.this.cwS.setVisibility(8);
            if (this.Tu != null && this.Tu.uh() && str != null && str.length() > 0) {
                com.baidu.adp.lib.g.k.hj().c(new k(this, str));
                com.baidu.tbadk.core.sharedPref.b.ts().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.akU() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.cwR.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(i.C0057i.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(i.C0057i.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akU() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.cwS.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
