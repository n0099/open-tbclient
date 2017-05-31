package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c fTw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.fTw = cVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        if (!StringUtils.isNull(str)) {
            aVar = this.fTw.fTp;
            if (aVar != null) {
                z = this.fTw.onPageFinishHasBeenCalled;
                if (z) {
                    aVar2 = this.fTw.fTp;
                    return aVar2.rc(str);
                }
                this.fTw.onPageFinishHasBeenCalled = true;
                this.fTw.showWebLoadingView(false);
                this.fTw.bnk();
                aVar3 = this.fTw.fTp;
                aVar3.bnh();
                return true;
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        a aVar;
        a aVar2;
        super.onPageFinished(webView, str);
        this.fTw.onPageFinishHasBeenCalled = true;
        aVar = this.fTw.fTp;
        if (aVar != null) {
            aVar2 = this.fTw.fTp;
            aVar2.bnh();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.fTw.showWebLoadingView(false);
        baseActivity = this.fTw.mContext;
        baseActivity.showToast(w.l.neterror);
        baseActivity2 = this.fTw.mContext;
        baseActivity2.finish();
    }
}
