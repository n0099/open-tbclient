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
/* loaded from: classes26.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView mBack = null;
    private a mVl = null;
    private LinearLayout mVm = null;
    private ProgressBar mVn = null;
    private ImageView mVo = null;
    private RelativeLayout kjG = null;
    private RelativeLayout mVp = null;
    private TextView bIt = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_activity);
        bLW();
        aG(bundle);
    }

    private void aG(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.APP_PULL_TIME, 0L) > 86400000) {
            refresh();
        } else if (!dIw()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.mVl != null) {
            this.mVl.cancel();
        }
        this.mVl = new a(this.mUrl);
        this.mVl.setPriority(3);
        this.mVl.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ap.setBgColor(this.kjG, i);
        ap.setBgColor(this.mWebView, i);
        ap.setTopBarBgImage(this.mVp, i);
        ap.setTopBarBackBgImage(this.mBack, i);
        ap.setTopBarTitleColor(this.bIt, i);
        ap.setTopBarRefrshBgImage(this.mVo, i);
    }

    private void bLW() {
        this.kjG = (RelativeLayout) findViewById(R.id.parent);
        this.mVp = (RelativeLayout) findViewById(R.id.title);
        this.bIt = (TextView) findViewById(R.id.title_text);
        this.mWebView = (BaseWebView) findViewById(R.id.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.mVn = (ProgressBar) findViewById(R.id.app_progress);
        this.mVm = (LinearLayout) findViewById(R.id.webview_fail_imageview);
        this.mVm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.mVo = (ImageView) findViewById(R.id.refresh);
        this.mVo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.2
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
    /* loaded from: classes26.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private aa cfI = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.mVn.setVisibility(0);
            AppsActivity.this.mVm.setVisibility(8);
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
            this.cfI = new aa(this.url);
            this.cfI.btv().bue().bui().mIsJson = false;
            this.cfI.addPostData("client", "android");
            return this.cfI.postNetData();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            AppsActivity.this.mVn.setVisibility(8);
            AppsActivity.this.mVl = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(final String str) {
            AppsActivity.this.mVn.setVisibility(8);
            if (this.cfI != null && this.cfI.isNetSuccess() && str != null && str.length() > 0) {
                com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.setting.more.AppsActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkCoreApplication.getInst().cashNoAccountData(str, 7);
                    }
                });
                com.baidu.tbadk.core.sharedPref.b.bsO().putLong(SharedPrefConfig.APP_PULL_TIME, System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.dIw() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.mVm.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(R.string.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(R.string.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIw() {
        String noAccountData = TbadkCoreApplication.getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.mVn.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
