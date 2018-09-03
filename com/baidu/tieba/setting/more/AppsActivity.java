package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.g.h;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.ar.util.IoUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView gyY = null;
    private a gyZ = null;
    private LinearLayout gza = null;
    private ProgressBar gzb = null;
    private ImageView gzc = null;
    private RelativeLayout mParent = null;
    private RelativeLayout gzd = null;
    private TextView cXY = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.app_activity);
        QP();
        C(bundle);
    }

    private void C(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!bpu()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.gyZ != null) {
            this.gyZ.cancel();
        }
        this.gyZ = new a(this.mUrl);
        this.gyZ.setPriority(3);
        this.gyZ.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.e(this.mParent, i);
        am.e(this.mWebView, i);
        am.g(this.gzd, i);
        am.a(this.gyY, i);
        am.c(this.cXY, i);
        am.b(this.gzc, i);
    }

    private void QP() {
        this.mParent = (RelativeLayout) findViewById(f.g.parent);
        this.gzd = (RelativeLayout) findViewById(f.g.title);
        this.cXY = (TextView) findViewById(f.g.title_text);
        this.mWebView = (BaseWebView) findViewById(f.g.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.gzb = (ProgressBar) findViewById(f.g.app_progress);
        this.gza = (LinearLayout) findViewById(f.g.webview_fail_imageview);
        this.gza.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.gzc = (ImageView) findViewById(f.g.refresh);
        this.gzc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.gyY = (ImageView) findViewById(f.g.back);
        this.gyY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private y mNetWork = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.gzb.setVisibility(0);
            AppsActivity.this.gza.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            if (this.url == null) {
                return null;
            }
            this.mNetWork = new y(this.url);
            this.mNetWork.yM().zK().zN().asu = false;
            this.mNetWork.o("client", HttpConstants.OS_TYPE_VALUE);
            return this.mNetWork.yo();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            AppsActivity.this.gzb.setVisibility(8);
            AppsActivity.this.gyZ = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(final String str) {
            AppsActivity.this.gzb.setVisibility(8);
            if (this.mNetWork != null && this.mNetWork.yP() && str != null && str.length() > 0) {
                h.io().d(new Runnable() { // from class: com.baidu.tieba.setting.more.AppsActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkCoreApplication.getInst().cashNoAccountData(str, 7);
                    }
                });
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", IoUtils.UTF_8, "");
            } else if (!AppsActivity.this.bpu() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.gza.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(f.j.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(f.j.server_404), "text/html", IoUtils.UTF_8, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bpu() {
        String noAccountData = TbadkCoreApplication.getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.gzb.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", IoUtils.UTF_8, "");
        return true;
    }
}
