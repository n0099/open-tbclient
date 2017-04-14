package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c fMG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.fMG = cVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        if (!StringUtils.isNull(str)) {
            aVar = this.fMG.fMz;
            if (aVar != null) {
                z = this.fMG.onPageFinishHasBeenCalled;
                if (z) {
                    aVar2 = this.fMG.fMz;
                    return aVar2.qU(str);
                }
                this.fMG.onPageFinishHasBeenCalled = true;
                this.fMG.showWebLoadingView(false);
                this.fMG.bng();
                aVar3 = this.fMG.fMz;
                aVar3.bnd();
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
        this.fMG.onPageFinishHasBeenCalled = true;
        aVar = this.fMG.fMz;
        if (aVar != null) {
            aVar2 = this.fMG.fMz;
            aVar2.bnd();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.fMG.showWebLoadingView(false);
        baseActivity = this.fMG.mContext;
        baseActivity.showToast(w.l.neterror);
        baseActivity2 = this.fMG.mContext;
        baseActivity2.finish();
    }
}
