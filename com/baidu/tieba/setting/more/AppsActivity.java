package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView mBack = null;
    private a naH = null;
    private LinearLayout naI = null;
    private ProgressBar naJ = null;
    private ImageView naK = null;
    private RelativeLayout ltF = null;
    private RelativeLayout naL = null;
    private TextView bNi = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_activity);
        bOo();
        aG(bundle);
    }

    private void aG(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bvq().getLong(SharedPrefConfig.APP_PULL_TIME, 0L) > 86400000) {
            refresh();
        } else if (!dIl()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.naH != null) {
            this.naH.cancel();
        }
        this.naH = new a(this.mUrl);
        this.naH.setPriority(3);
        this.naH.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ao.setBgColor(this.ltF, i);
        ao.setBgColor(this.mWebView, i);
        ao.setTopBarBgImage(this.naL, i);
        ao.setTopBarBackBgImage(this.mBack, i);
        ao.setTopBarTitleColor(this.bNi, i);
        ao.setTopBarRefrshBgImage(this.naK, i);
    }

    private void bOo() {
        this.ltF = (RelativeLayout) findViewById(R.id.parent);
        this.naL = (RelativeLayout) findViewById(R.id.title);
        this.bNi = (TextView) findViewById(R.id.title_text);
        this.mWebView = (BaseWebView) findViewById(R.id.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.naJ = (ProgressBar) findViewById(R.id.app_progress);
        this.naI = (LinearLayout) findViewById(R.id.webview_fail_imageview);
        this.naI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.naK = (ImageView) findViewById(R.id.refresh);
        this.naK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.2
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
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private z cmJ = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.naJ.setVisibility(0);
            AppsActivity.this.naI.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: l */
        public String doInBackground(Object... objArr) {
            if (this.url == null) {
                return null;
            }
            this.cmJ = new z(this.url);
            this.cmJ.bvQ().bwz().bwD().mIsJson = false;
            this.cmJ.addPostData("client", HttpConstants.OS_TYPE_VALUE);
            return this.cmJ.postNetData();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            AppsActivity.this.naJ.setVisibility(8);
            AppsActivity.this.naH = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(final String str) {
            AppsActivity.this.naJ.setVisibility(8);
            if (this.cmJ != null && this.cmJ.isNetSuccess() && str != null && str.length() > 0) {
                com.baidu.adp.lib.f.h.mC().submitTask(new Runnable() { // from class: com.baidu.tieba.setting.more.AppsActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkCoreApplication.getInst().cashNoAccountData(str, 7);
                    }
                });
                com.baidu.tbadk.core.sharedPref.b.bvq().putLong(SharedPrefConfig.APP_PULL_TIME, System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", "utf-8", "");
            } else if (!AppsActivity.this.dIl() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.naI.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(R.string.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(R.string.server_404), "text/html", "utf-8", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIl() {
        String noAccountData = TbadkCoreApplication.getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.naJ.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
