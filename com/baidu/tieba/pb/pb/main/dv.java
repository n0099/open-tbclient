package com.baidu.tieba.pb.pb.main;

import android.webkit.WebView;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
class dv implements BaseWebView.c {
    final /* synthetic */ dr eoS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dv(dr drVar) {
        this.eoS = drVar;
    }

    @Override // com.baidu.tbadk.coreExtra.view.BaseWebView.c
    public void onPageFinished(WebView webView, String str) {
        webView.loadUrl("javascript:(function(){var iframe=document.getElementsByClassName(\"video_iframe\");if(iframe&&iframe.length>0){for(var i=iframe.length-1;i>=0;i--){iframe[i].contentWindow.document.getElementsByClassName(\"tvp_fullscreen_button\")[0].style.display=\"none\"}}})();");
    }
}
