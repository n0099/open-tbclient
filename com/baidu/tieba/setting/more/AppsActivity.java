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
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView Ez = null;
    private a jRr = null;
    private LinearLayout jRs = null;
    private ProgressBar jRt = null;
    private ImageView jRu = null;
    private RelativeLayout hpY = null;
    private RelativeLayout jRv = null;
    private TextView ayC = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_activity);
        aVq();
        ax(bundle);
    }

    private void ax(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.APP_PULL_TIME, 0L) > 86400000) {
            refresh();
        } else if (!cDQ()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.jRr != null) {
            this.jRr.cancel();
        }
        this.jRr = new a(this.mUrl);
        this.jRr.setPriority(3);
        this.jRr.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setBgColor(this.hpY, i);
        am.setBgColor(this.mWebView, i);
        am.setTopBarBgImage(this.jRv, i);
        am.setTopBarBackBgImage(this.Ez, i);
        am.setTopBarTitleColor(this.ayC, i);
        am.setTopBarRefrshBgImage(this.jRu, i);
    }

    private void aVq() {
        this.hpY = (RelativeLayout) findViewById(R.id.parent);
        this.jRv = (RelativeLayout) findViewById(R.id.title);
        this.ayC = (TextView) findViewById(R.id.title_text);
        this.mWebView = (BaseWebView) findViewById(R.id.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.jRt = (ProgressBar) findViewById(R.id.app_progress);
        this.jRs = (LinearLayout) findViewById(R.id.webview_fail_imageview);
        this.jRs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.jRu = (ImageView) findViewById(R.id.refresh);
        this.jRu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.Ez = (ImageView) findViewById(R.id.back);
        this.Ez.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private x cHA = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.jRt.setVisibility(0);
            AppsActivity.this.jRs.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            if (this.url == null) {
                return null;
            }
            this.cHA = new x(this.url);
            this.cHA.aDU().aEu().aEx().mIsJson = false;
            this.cHA.addPostData("client", PraiseDataPassUtil.KEY_FROM_OS);
            return this.cHA.postNetData();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cHA != null) {
                this.cHA.cancelNetConnect();
            }
            AppsActivity.this.jRt.setVisibility(8);
            AppsActivity.this.jRr = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(final String str) {
            AppsActivity.this.jRt.setVisibility(8);
            if (this.cHA != null && this.cHA.isNetSuccess() && str != null && str.length() > 0) {
                com.baidu.adp.lib.f.h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.setting.more.AppsActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkCoreApplication.getInst().cashNoAccountData(str, 7);
                    }
                });
                com.baidu.tbadk.core.sharedPref.b.aDr().putLong(SharedPrefConfig.APP_PULL_TIME, System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.cDQ() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.jRs.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(R.string.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(R.string.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDQ() {
        String noAccountData = TbadkCoreApplication.getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.jRt.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
