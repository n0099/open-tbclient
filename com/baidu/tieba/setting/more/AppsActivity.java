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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView gPj = null;
    private a gPk = null;
    private LinearLayout gPl = null;
    private ProgressBar gPm = null;
    private ImageView gPn = null;
    private RelativeLayout mParent = null;
    private RelativeLayout gPo = null;
    private TextView dne = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.app_activity);
        UI();
        G(bundle);
    }

    private void G(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString("url");
        } else {
            this.mUrl = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!buM()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.gPk != null) {
            this.gPk.cancel();
        }
        this.gPk = new a(this.mUrl);
        this.gPk.setPriority(3);
        this.gPk.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.e(this.mParent, i);
        al.e(this.mWebView, i);
        al.g(this.gPo, i);
        al.a(this.gPj, i);
        al.c(this.dne, i);
        al.b(this.gPn, i);
    }

    private void UI() {
        this.mParent = (RelativeLayout) findViewById(e.g.parent);
        this.gPo = (RelativeLayout) findViewById(e.g.title);
        this.dne = (TextView) findViewById(e.g.title_text);
        this.mWebView = (BaseWebView) findViewById(e.g.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.gPm = (ProgressBar) findViewById(e.g.app_progress);
        this.gPl = (LinearLayout) findViewById(e.g.webview_fail_imageview);
        this.gPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.gPn = (ImageView) findViewById(e.g.refresh);
        this.gPn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.refresh();
            }
        });
        this.gPj = (ImageView) findViewById(e.g.back);
        this.gPj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.setting.more.AppsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AppsActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, String> {
        private x mNetWork = null;
        private String url;

        public a(String str) {
            this.url = null;
            this.url = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            AppsActivity.this.gPm.setVisibility(0);
            AppsActivity.this.gPl.setVisibility(8);
            AppsActivity.this.mWebView.setVisibility(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Object... objArr) {
            if (this.url == null) {
                return null;
            }
            this.mNetWork = new x(this.url);
            this.mNetWork.Cf().Dd().Dg().aAs = false;
            this.mNetWork.x("client", HttpConstants.OS_TYPE_VALUE);
            return this.mNetWork.BH();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            AppsActivity.this.gPm.setVisibility(8);
            AppsActivity.this.gPk = null;
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(final String str) {
            AppsActivity.this.gPm.setVisibility(8);
            if (this.mNetWork != null && this.mNetWork.Ci() && str != null && str.length() > 0) {
                h.jH().d(new Runnable() { // from class: com.baidu.tieba.setting.more.AppsActivity.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TbadkCoreApplication.getInst().cashNoAccountData(str, 7);
                    }
                });
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("app_inverval", System.currentTimeMillis());
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, str, "text/html", IoUtils.UTF_8, "");
            } else if (!AppsActivity.this.buM() && str == null) {
                AppsActivity.this.mWebView.setVisibility(8);
                AppsActivity.this.gPl.setVisibility(0);
                AppsActivity.this.showToast(AppsActivity.this.getPageContext().getString(e.j.neterror));
            } else {
                AppsActivity.this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, AppsActivity.this.getPageContext().getString(e.j.server_404), "text/html", IoUtils.UTF_8, "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean buM() {
        String noAccountData = TbadkCoreApplication.getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.gPm.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", IoUtils.UTF_8, "");
        return true;
    }
}
