package com.baidu.tieba.pb.pb.main;

import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
class eb implements BaseWebView.b {
    final /* synthetic */ dy exY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(dy dyVar) {
        this.exY = dyVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return true;
    }
}
