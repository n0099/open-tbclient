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
    private ImageView bZY = null;
    private i bZZ = null;
    private LinearLayout caa = null;
    private ProgressBar cab = null;
    private ImageView cac = null;
    private RelativeLayout aWN = null;
    private RelativeLayout cad = null;
    private TextView mTitleText = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.app_activity);
        Ee();
        l(bundle);
    }

    private void l(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString(ImageViewerConfig.URL);
        } else {
            this.mUrl = getIntent().getStringExtra(ImageViewerConfig.URL);
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.rB().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!agl()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.bZZ != null) {
            this.bZZ.cancel();
        }
        this.bZZ = new i(this, this.mUrl);
        this.bZZ.setPriority(3);
        this.bZZ.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ba.e(this.aWN, i);
        com.baidu.tbadk.core.util.ba.e(this.mWebView, i);
        com.baidu.tbadk.core.util.ba.h(this.cad, i);
        com.baidu.tbadk.core.util.ba.a(this.bZY, i);
        com.baidu.tbadk.core.util.ba.e(this.mTitleText, i);
        com.baidu.tbadk.core.util.ba.b(this.cac, i);
    }

    private void Ee() {
        this.aWN = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.cad = (RelativeLayout) findViewById(com.baidu.tieba.v.title);
        this.mTitleText = (TextView) findViewById(com.baidu.tieba.v.title_text);
        this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.v.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.cab = (ProgressBar) findViewById(com.baidu.tieba.v.app_progress);
        this.caa = (LinearLayout) findViewById(com.baidu.tieba.v.webview_fail_imageview);
        this.caa.setOnClickListener(new f(this));
        this.cac = (ImageView) findViewById(com.baidu.tieba.v.refresh);
        this.cac.setOnClickListener(new g(this));
        this.bZY = (ImageView) findViewById(com.baidu.tieba.v.back);
        this.bZY.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agl() {
        String noAccountData = TbadkCoreApplication.m411getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.cab.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
