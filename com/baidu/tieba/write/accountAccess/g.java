package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c fPc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.fPc = cVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        if (!StringUtils.isNull(str)) {
            aVar = this.fPc.fOV;
            if (aVar != null) {
                z = this.fPc.onPageFinishHasBeenCalled;
                if (z) {
                    aVar2 = this.fPc.fOV;
                    return aVar2.qV(str);
                }
                this.fPc.onPageFinishHasBeenCalled = true;
                this.fPc.showWebLoadingView(false);
                this.fPc.boh();
                aVar3 = this.fPc.fOV;
                aVar3.boe();
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
        this.fPc.onPageFinishHasBeenCalled = true;
        aVar = this.fPc.fOV;
        if (aVar != null) {
            aVar2 = this.fPc.fOV;
            aVar2.boe();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.fPc.showWebLoadingView(false);
        baseActivity = this.fPc.mContext;
        baseActivity.showToast(w.l.neterror);
        baseActivity2 = this.fPc.mContext;
        baseActivity2.finish();
    }
}
