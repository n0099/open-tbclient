package com.baidu.tieba.pb.pb.main;

import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
class du implements BaseWebView.b {
    final /* synthetic */ dr eoS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(dr drVar) {
        this.eoS = drVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.b
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return true;
    }
}
