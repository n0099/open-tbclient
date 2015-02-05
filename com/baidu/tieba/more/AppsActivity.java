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
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
public class AppsActivity extends BaseActivity<AppsActivity> {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView Bo = null;
    private i bvc = null;
    private LinearLayout bvd = null;
    private ProgressBar bve = null;
    private ImageView Bn = null;
    private RelativeLayout mParent = null;
    private RelativeLayout bvf = null;
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
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.oc().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!UO()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.bvc != null) {
            this.bvc.cancel();
        }
        this.bvc = new i(this, this.mUrl);
        this.bvc.setPriority(3);
        this.bvc.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.bc.e(this.mParent, i);
        com.baidu.tbadk.core.util.bc.e(this.mWebView, i);
        com.baidu.tbadk.core.util.bc.h(this.bvf, i);
        com.baidu.tbadk.core.util.bc.a(this.Bo, i);
        com.baidu.tbadk.core.util.bc.e(this.mTitleText, i);
        com.baidu.tbadk.core.util.bc.b(this.Bn, i);
    }

    private void InitUI() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.w.parent);
        this.bvf = (RelativeLayout) findViewById(com.baidu.tieba.w.title);
        this.mTitleText = (TextView) findViewById(com.baidu.tieba.w.title_text);
        this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.w.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.bve = (ProgressBar) findViewById(com.baidu.tieba.w.app_progress);
        this.bvd = (LinearLayout) findViewById(com.baidu.tieba.w.webview_fail_imageview);
        this.bvd.setOnClickListener(new f(this));
        this.Bn = (ImageView) findViewById(com.baidu.tieba.w.refresh);
        this.Bn.setOnClickListener(new g(this));
        this.Bo = (ImageView) findViewById(com.baidu.tieba.w.back);
        this.Bo.setOnClickListener(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean UO() {
        String noAccountData = TbadkCoreApplication.m255getInst().getNoAccountData(7);
        if (noAccountData == null || noAccountData.length() <= 1) {
            return false;
        }
        this.bve.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, noAccountData, "text/html", "utf-8", "");
        return true;
    }
}
