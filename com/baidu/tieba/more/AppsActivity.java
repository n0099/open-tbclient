package com.baidu.tieba.more;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AppsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView Br = null;
    private i btG = null;
    private LinearLayout btH = null;
    private ProgressBar btI = null;
    private ImageView Bq = null;
    private RelativeLayout mParent = null;
    private RelativeLayout btJ = null;
    private TextView mTitleText = null;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(AppsActivityConfig.class, AppsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.app_activity);
        InitUI();
        h(bundle);
    }

    private void h(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString(ImageViewerConfig.URL);
        } else {
            this.mUrl = getIntent().getStringExtra(ImageViewerConfig.URL);
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.og().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!Uv()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.btG != null) {
            this.btG.cancel();
        }
        this.btG = new i(this, this.mUrl);
        this.btG.setPriority(3);
        this.btG.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ax.e(this.mParent, i);
        ax.e(this.mWebView, i);
        ax.h(this.btJ, i);
        ax.a(this.Br, i);
        ax.e(this.mTitleText, i);
        ax.b(this.Bq, i);
    }

    private void InitUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.w.parent);
        this.btJ = (RelativeLayout) findViewById(com.baidu.tieba.w.title);
        this.mTitleText = (TextView) findViewById(com.baidu.tieba.w.title_text);
        this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.w.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.btI = (ProgressBar) findViewById(com.baidu.tieba.w.app_progress);
        this.btH = (LinearLayout) findViewById(com.baidu.tieba.w.webview_fail_imageview);
        this.btH.setOnClickListener(new f(this));
        this.Bq = (ImageView) findViewById(com.baidu.tieba.w.refresh);
        this.Bq.setOnClickListener(new g(this));
        this.Br = (ImageView) findViewById(com.baidu.tieba.w.back);
        this.Br.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Uv() {
        String noAccountData = TbadkCoreApplication.m255getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.btI.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
