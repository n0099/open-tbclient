package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c fxY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.fxY = cVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        if (!StringUtils.isNull(str)) {
            aVar = this.fxY.fxQ;
            if (aVar != null) {
                z = this.fxY.cki;
                if (z) {
                    aVar2 = this.fxY.fxQ;
                    return aVar2.qY(str);
                }
                this.fxY.cki = true;
                this.fxY.lv(false);
                this.fxY.bll();
                aVar3 = this.fxY.fxQ;
                aVar3.blh();
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
        this.fxY.cki = true;
        aVar = this.fxY.fxQ;
        if (aVar != null) {
            aVar2 = this.fxY.fxQ;
            aVar2.blh();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.fxY.lv(false);
        baseActivity = this.fxY.awe;
        baseActivity.showToast(r.j.neterror);
        baseActivity2 = this.fxY.awe;
        baseActivity2.finish();
    }
}
