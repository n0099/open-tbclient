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
    private ImageView cFm = null;
    private a cFn = null;
    private LinearLayout cFo = null;
    private ProgressBar cFp = null;
    private ImageView cFq = null;
    private RelativeLayout boe = null;
    private RelativeLayout cFr = null;
    private TextView LM = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.app_activity);
        FY();
        j(bundle);
    }

    private void j(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.tx().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!apb()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.cFn != null) {
            this.cFn.cancel();
        }
        this.cFn = new a(this.mUrl);
        this.cFn.setPriority(3);
        this.cFn.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.al.e(this.boe, i);
        com.baidu.tbadk.core.util.al.e(this.mWebView, i);
        com.baidu.tbadk.core.util.al.g(this.cFr, i);
        com.baidu.tbadk.core.util.al.a(this.cFm, i);
        com.baidu.tbadk.core.util.al.e(this.LM, i);
        com.baidu.tbadk.core.util.al.b(this.cFq, i);
    }

    private void FY() {
        this.boe = (RelativeLayout) findViewById(i.f.parent);
        this.cFr = (RelativeLayout) findViewById(i.f.title);
        this.LM = (TextView) findViewById(i.f.title_text);
        this.mWebView = (BaseWebView) findViewById(i.f.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.cFp = (ProgressBar) findViewById(i.f.app_progress);
        this.cFo = (LinearLayout) findViewById(i.f.webview_fail_imageview);
        this.cFo.setOnClickListener(new h(this));
        this.cFq = (ImageView) findViewById(i.f.refresh);
        this.cFq.setOnClickListener(new i(this));
        this.cFm = (ImageView) findViewById(i.f.back);
        this.cFm.setOnClickListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private com.baidu.tbadk.core.util.v Tv = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.cFp.setVisibility(0);
            AppsActivity.this.cFo.setVisibility(8);
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
            this.Tv = new com.baidu.tbadk.core.util.v(this.url);
            this.Tv.uj().uZ().vc().acm = false;
            this.Tv.o("client", SocialConstants.ANDROID_CLIENT_TYPE);
            return this.Tv.tI();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Tv != null) {
                this.Tv.gJ();
            }
            AppsActivity.this.cFp.setVisibility(8);
            AppsActivity.this.cFn = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            AppsActivity.this.cFp.setVisibility(8);
            if (this.Tv != null && this.Tv.um() && str != null && str.length() > 0) {
                com.baidu.adp.lib.g.k.hg().c(new k(this, str));
                com.baidu.tbadk.core.sharedPref.b.tx().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.apb() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.cFo.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(i.h.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(i.h.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apb() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.cFp.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
