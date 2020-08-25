package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView mBack = null;
    private a lPd = null;
    private LinearLayout lPe = null;
    private ProgressBar lPf = null;
    private ImageView lPg = null;
    private RelativeLayout jfk = null;
    private RelativeLayout lPh = null;
    private TextView bpx = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_activity);
        bAC();
        aF(bundle);
    }

    private void aF(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.APP_PULL_TIME, 0L) > 86400000) {
            refresh();
        } else if (!dqt()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.lPd != null) {
            this.lPd.cancel();
        }
        this.lPd = new a(this.mUrl);
        this.lPd.setPriority(3);
        this.lPd.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBgColor(this.jfk, i);
        ap.setBgColor(this.mWebView, i);
        ap.setTopBarBgImage(this.lPh, i);
        ap.setTopBarBackBgImage(this.mBack, i);
        ap.setTopBarTitleColor(this.bpx, i);
        ap.setTopBarRefrshBgImage(this.lPg, i);
    }

    private void bAC() {
        this.jfk = (RelativeLayout) findViewById(R.id.parent);
        this.lPh = (RelativeLayout) findViewById(R.id.title);
        this.bpx = (TextView) findViewById(R.id.title_text);
        this.mWebView = (BaseWebView) findViewById(R.id.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.lPf = (ProgressBar) findViewById(R.id.app_progress);
        this.lPe = (LinearLayout) findViewById(R.id.webview_fail_imageview);
        this.lPe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.lPg = (ImageView) findViewById(R.id.refresh);
        this.lPg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.mBack = (ImageView) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private aa bDY = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.lPf.setVisibility(0);
            AppsActivity.this.lPe.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: k */
        public String doInBackground(Object... objArr) {
            if (this.url == null) {
                return null;
            }
            this.bDY = new aa(this.url);
            this.bDY.biQ().bjv().bjz().mIsJson = false;
            this.bDY.addPostData("client", "android");
            return this.bDY.postNetData();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
            }
            AppsActivity.this.lPf.setVisibility(8);
            AppsActivity.this.lPd = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(final String str) {
            AppsActivity.this.lPf.setVisibility(8);
            if (this.bDY != null && this.bDY.isNetSuccess() && str != null && str.length() > 0) {
                com.baidu.adp.lib.f.h.mT().submitTask(new Runnable() { // from class: com.baidu.tieba.setting.more.AppsActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkCoreApplication.getInst().cashNoAccountData(str, 7);
                    }
                });
                com.baidu.tbadk.core.sharedPref.b.bik().putLong(SharedPrefConfig.APP_PULL_TIME, System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.dqt() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.lPe.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(R.string.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(R.string.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dqt() {
        String noAccountData = TbadkCoreApplication.getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.lPf.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
