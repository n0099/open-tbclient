package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
public class AppsActivity extends BaseActivity {
    private String mUrl = null;
    private BaseWebView mWebView = null;
    private ImageView xL = null;
    private j bqs = null;
    private LinearLayout bqt = null;
    private ProgressBar bqu = null;
    private ImageView xK = null;
    private RelativeLayout mParent = null;
    private RelativeLayout bqv = null;
    private TextView atJ = null;

    public static void startActivity(Context context, String str) {
        Intent intent = new Intent(context, AppsActivity.class);
        intent.putExtra(ImageViewerConfig.URL, str);
        context.startActivity(intent);
    }

    public static void Uh() {
        com.baidu.adp.lib.g.k.el().b(new f());
        com.baidu.tbadk.core.sharedPref.b.lk().putLong("app_inverval", System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.app_activity);
        iT();
        a(bundle);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.mUrl = bundle.getString(ImageViewerConfig.URL);
        } else {
            this.mUrl = getIntent().getStringExtra(ImageViewerConfig.URL);
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.lk().getLong("app_inverval", 0L) > 86400000) {
            refresh();
        } else if (!Ui()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.bqs != null) {
            this.bqs.cancel();
        }
        this.bqs = new j(this, this.mUrl);
        this.bqs.setPriority(3);
        this.bqs.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.d(this.mParent, i);
        com.baidu.tbadk.core.util.aw.d(this.mWebView, i);
        com.baidu.tbadk.core.util.aw.g(this.bqv, i);
        com.baidu.tbadk.core.util.aw.a(this.xL, i);
        com.baidu.tbadk.core.util.aw.d(this.atJ, i);
        com.baidu.tbadk.core.util.aw.b(this.xK, i);
    }

    private void iT() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.bqv = (RelativeLayout) findViewById(com.baidu.tieba.v.title);
        this.atJ = (TextView) findViewById(com.baidu.tieba.v.title_text);
        this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.v.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.bqu = (ProgressBar) findViewById(com.baidu.tieba.v.app_progress);
        this.bqt = (LinearLayout) findViewById(com.baidu.tieba.v.webview_fail_imageview);
        this.bqt.setOnClickListener(new g(this));
        this.xK = (ImageView) findViewById(com.baidu.tieba.v.refresh);
        this.xK.setOnClickListener(new h(this));
        this.xL = (ImageView) findViewById(com.baidu.tieba.v.back);
        this.xL.setOnClickListener(new i(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ui() {
        String hA = com.baidu.tieba.util.j.hA(7);
        if (hA == null || hA.length() <= 1) {
            return false;
        }
        this.bqu.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, hA, "text/html", "utf-8", "");
        return true;
    }
}
