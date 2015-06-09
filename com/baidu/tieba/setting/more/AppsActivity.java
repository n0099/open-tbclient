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
    private ImageView ceK = null;
    private i ceL = null;
    private LinearLayout ceM = null;
    private ProgressBar ceN = null;
    private ImageView ceO = null;
    private RelativeLayout aZK = null;
    private RelativeLayout ceP = null;
    private TextView mTitleText = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.app_activity);
        EY();
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
        } else if (!aiu()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.ceL != null) {
            this.ceL.cancel();
        }
        this.ceL = new i(this, this.mUrl);
        this.ceL.setPriority(3);
        this.ceL.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ay.e(this.aZK, i);
        com.baidu.tbadk.core.util.ay.e(this.mWebView, i);
        com.baidu.tbadk.core.util.ay.h(this.ceP, i);
        com.baidu.tbadk.core.util.ay.a(this.ceK, i);
        com.baidu.tbadk.core.util.ay.e(this.mTitleText, i);
        com.baidu.tbadk.core.util.ay.b(this.ceO, i);
    }

    private void EY() {
        this.aZK = (RelativeLayout) findViewById(com.baidu.tieba.q.parent);
        this.ceP = (RelativeLayout) findViewById(com.baidu.tieba.q.title);
        this.mTitleText = (TextView) findViewById(com.baidu.tieba.q.title_text);
        this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.q.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.ceN = (ProgressBar) findViewById(com.baidu.tieba.q.app_progress);
        this.ceM = (LinearLayout) findViewById(com.baidu.tieba.q.webview_fail_imageview);
        this.ceM.setOnClickListener(new f(this));
        this.ceO = (ImageView) findViewById(com.baidu.tieba.q.refresh);
        this.ceO.setOnClickListener(new g(this));
        this.ceK = (ImageView) findViewById(com.baidu.tieba.q.back);
        this.ceK.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aiu() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.ceN.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
