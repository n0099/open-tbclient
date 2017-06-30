package com.baidu.tieba.pb.pb.main;

import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
class ec implements BaseWebView.c {
    final /* synthetic */ dy exY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(dy dyVar) {
        this.exY = dyVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
    }
}
