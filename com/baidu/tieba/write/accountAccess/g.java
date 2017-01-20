package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c fGD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.fGD = cVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        if (!StringUtils.isNull(str)) {
            aVar = this.fGD.fGw;
            if (aVar != null) {
                z = this.fGD.onPageFinishHasBeenCalled;
                if (z) {
                    aVar2 = this.fGD.fGw;
                    return aVar2.rs(str);
                }
                this.fGD.onPageFinishHasBeenCalled = true;
                this.fGD.showWebLoadingView(false);
                this.fGD.bmJ();
                aVar3 = this.fGD.fGw;
                aVar3.bmG();
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
        this.fGD.onPageFinishHasBeenCalled = true;
        aVar = this.fGD.fGw;
        if (aVar != null) {
            aVar2 = this.fGD.fGw;
            aVar2.bmG();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.fGD.showWebLoadingView(false);
        baseActivity = this.fGD.mContext;
        baseActivity.showToast(r.l.neterror);
        baseActivity2 = this.fGD.mContext;
        baseActivity2.finish();
    }
}
