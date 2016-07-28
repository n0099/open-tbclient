package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c fPL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.fPL = cVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        if (StringUtils.isNull(str)) {
            return false;
        }
        aVar = this.fPL.fPC;
        if (aVar == null) {
            return false;
        }
        z = this.fPL.cnV;
        if (!z) {
            this.fPL.cnV = true;
            this.fPL.lq(false);
            this.fPL.bnd();
            aVar3 = this.fPL.fPC;
            aVar3.bmY();
        }
        aVar2 = this.fPL.fPC;
        return aVar2.rs(str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        a aVar;
        a aVar2;
        super.onPageFinished(webView, str);
        this.fPL.cnV = true;
        aVar = this.fPL.fPC;
        if (aVar != null) {
            aVar2 = this.fPL.fPC;
            aVar2.bmY();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.fPL.lq(false);
        baseActivity = this.fPL.ate;
        baseActivity.showToast(u.j.neterror);
        baseActivity2 = this.fPL.ate;
        baseActivity2.finish();
    }
}
