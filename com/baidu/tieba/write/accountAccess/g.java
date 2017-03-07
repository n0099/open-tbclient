package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c fKX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.fKX = cVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        if (!StringUtils.isNull(str)) {
            aVar = this.fKX.fKQ;
            if (aVar != null) {
                z = this.fKX.onPageFinishHasBeenCalled;
                if (z) {
                    aVar2 = this.fKX.fKQ;
                    return aVar2.qA(str);
                }
                this.fKX.onPageFinishHasBeenCalled = true;
                this.fKX.showWebLoadingView(false);
                this.fKX.bmw();
                aVar3 = this.fKX.fKQ;
                aVar3.bmt();
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
        this.fKX.onPageFinishHasBeenCalled = true;
        aVar = this.fKX.fKQ;
        if (aVar != null) {
            aVar2 = this.fKX.fKQ;
            aVar2.bmt();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.fKX.showWebLoadingView(false);
        baseActivity = this.fKX.mContext;
        baseActivity.showToast(w.l.neterror);
        baseActivity2 = this.fKX.mContext;
        baseActivity2.finish();
    }
}
