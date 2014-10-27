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
    private j bqe = null;
    private LinearLayout bqf = null;
    private ProgressBar bqg = null;
    private ImageView xK = null;
    private RelativeLayout mParent = null;
    private RelativeLayout bqh = null;
    private TextView atA = null;

    public static void startActivity(Context context, String str) {
        Intent intent = new Intent(context, AppsActivity.class);
        intent.putExtra(ImageViewerConfig.URL, str);
        context.startActivity(intent);
    }

    public static void Ue() {
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
        } else if (!Uf()) {
            refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        if (this.bqe != null) {
            this.bqe.cancel();
        }
        this.bqe = new j(this, this.mUrl);
        this.bqe.setPriority(3);
        this.bqe.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.aw.d(this.mParent, i);
        com.baidu.tbadk.core.util.aw.d(this.mWebView, i);
        com.baidu.tbadk.core.util.aw.g(this.bqh, i);
        com.baidu.tbadk.core.util.aw.a(this.xL, i);
        com.baidu.tbadk.core.util.aw.d(this.atA, i);
        com.baidu.tbadk.core.util.aw.b(this.xK, i);
    }

    private void iT() {
        this.mParent = (RelativeLayout) findViewById(com.baidu.tieba.v.parent);
        this.bqh = (RelativeLayout) findViewById(com.baidu.tieba.v.title);
        this.atA = (TextView) findViewById(com.baidu.tieba.v.title_text);
        this.mWebView = (BaseWebView) findViewById(com.baidu.tieba.v.app_webView);
        this.mWebView.setDownloadEnabled(true);
        this.bqg = (ProgressBar) findViewById(com.baidu.tieba.v.app_progress);
        this.bqf = (LinearLayout) findViewById(com.baidu.tieba.v.webview_fail_imageview);
        this.bqf.setOnClickListener(new g(this));
        this.xK = (ImageView) findViewById(com.baidu.tieba.v.refresh);
        this.xK.setOnClickListener(new h(this));
        this.xL = (ImageView) findViewById(com.baidu.tieba.v.back);
        this.xL.setOnClickListener(new i(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Uf() {
        String hA = com.baidu.tieba.util.j.hA(7);
        if (hA == null || hA.length() <= 1) {
            return false;
        }
        this.bqg.setVisibility(8);
        this.mWebView.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, hA, "text/html", "utf-8", "");
        return true;
    }
}
