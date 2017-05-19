package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c fLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.fLP = cVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        if (!StringUtils.isNull(str)) {
            aVar = this.fLP.fLI;
            if (aVar != null) {
                z = this.fLP.onPageFinishHasBeenCalled;
                if (z) {
                    aVar2 = this.fLP.fLI;
                    return aVar2.qP(str);
                }
                this.fLP.onPageFinishHasBeenCalled = true;
                this.fLP.showWebLoadingView(false);
                this.fLP.blN();
                aVar3 = this.fLP.fLI;
                aVar3.blK();
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
        this.fLP.onPageFinishHasBeenCalled = true;
        aVar = this.fLP.fLI;
        if (aVar != null) {
            aVar2 = this.fLP.fLI;
            aVar2.blK();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.fLP.showWebLoadingView(false);
        baseActivity = this.fLP.mContext;
        baseActivity.showToast(w.l.neterror);
        baseActivity2 = this.fLP.mContext;
        baseActivity2.finish();
    }
}
