package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView ceJ = null;
    private i ceK = null;
    private LinearLayout ceL = null;
    private ProgressBar ceM = null;
    private ImageView ceN = null;
    private RelativeLayout aZJ = null;
    private RelativeLayout ceO = null;
    private TextView mTitleText = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.app_activity);
        EX();
        k(bundle);
    }

    private void k(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString(ImageViewerConfig.URL);
        } else {
            this.mUrl = getIntent().getStringExtra(ImageViewerConfig.URL);
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.sl().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!ait()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.ceK != null) {
            this.ceK.cancel();
        }
        this.ceK = new i(this, this.mUrl);
        this.ceK.setPriority(3);
        this.ceK.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ay.e(this.aZJ, i);
        com.baidu.tbadk.core.util.ay.e(this.mWebView, i);
        com.baidu.tbadk.core.util.ay.h(this.ceO, i);
        com.baidu.tbadk.core.util.ay.a(this.ceJ, i);
        com.baidu.tbadk.core.util.ay.e(this.mTitleText, i);
        com.baidu.tbadk.core.util.ay.b(this.ceN, i);
    }

    private void EX() {
        this.aZJ = (RelativeLayout) findViewById(com.baidu.tieba.q.parent);
        this.ceO = (RelativeLayout) findViewById(com.baidu.tieba.q.title);
        this.mTitleText = (TextView) findViewById(com.baidu.tieba.q.title_text);
        this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.q.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.ceM = (ProgressBar) findViewById(com.baidu.tieba.q.app_progress);
        this.ceL = (LinearLayout) findViewById(com.baidu.tieba.q.webview_fail_imageview);
        this.ceL.setOnClickListener(new f(this));
        this.ceN = (ImageView) findViewById(com.baidu.tieba.q.refresh);
        this.ceN.setOnClickListener(new g(this));
        this.ceJ = (ImageView) findViewById(com.baidu.tieba.q.back);
        this.ceJ.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ait() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.ceM.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
