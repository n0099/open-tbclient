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
    private ImageView cMn = null;
    private a cMo = null;
    private LinearLayout cMp = null;
    private ProgressBar cMq = null;
    private ImageView cMr = null;
    private RelativeLayout brd = null;
    private RelativeLayout cMs = null;
    private TextView LM = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.app_activity);
        FS();
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
        } else if (!art()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.cMo != null) {
            this.cMo.cancel();
        }
        this.cMo = new a(this.mUrl);
        this.cMo.setPriority(3);
        this.cMo.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.am.e(this.brd, i);
        com.baidu.tbadk.core.util.am.e(this.mWebView, i);
        com.baidu.tbadk.core.util.am.g(this.cMs, i);
        com.baidu.tbadk.core.util.am.a(this.cMn, i);
        com.baidu.tbadk.core.util.am.e(this.LM, i);
        com.baidu.tbadk.core.util.am.b(this.cMr, i);
    }

    private void FS() {
        this.brd = (RelativeLayout) findViewById(i.f.parent);
        this.cMs = (RelativeLayout) findViewById(i.f.title);
        this.LM = (TextView) findViewById(i.f.title_text);
        this.mWebView = (BaseWebView) findViewById(i.f.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.cMq = (ProgressBar) findViewById(i.f.app_progress);
        this.cMp = (LinearLayout) findViewById(i.f.webview_fail_imageview);
        this.cMp.setOnClickListener(new h(this));
        this.cMr = (ImageView) findViewById(i.f.refresh);
        this.cMr.setOnClickListener(new i(this));
        this.cMn = (ImageView) findViewById(i.f.back);
        this.cMn.setOnClickListener(new j(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private com.baidu.tbadk.core.util.w Th = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.cMq.setVisibility(0);
            AppsActivity.this.cMp.setVisibility(8);
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
            this.Th = new com.baidu.tbadk.core.util.w(this.url);
            this.Th.uh().uX().va().acl = false;
            this.Th.o("client", SocialConstants.ANDROID_CLIENT_TYPE);
            return this.Th.tG();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.Th != null) {
                this.Th.gJ();
            }
            AppsActivity.this.cMq.setVisibility(8);
            AppsActivity.this.cMo = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            AppsActivity.this.cMq.setVisibility(8);
            if (this.Th != null && this.Th.uk() && str != null && str.length() > 0) {
                com.baidu.adp.lib.g.k.hh().c(new k(this, str));
                com.baidu.tbadk.core.sharedPref.b.tu().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.art() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.cMp.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(i.h.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(i.h.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean art() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.cMq.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
