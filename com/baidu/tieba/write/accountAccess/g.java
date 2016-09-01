package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c fZP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.fZP = cVar;
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
        aVar = this.fZP.fZH;
        if (aVar == null) {
            return false;
        }
        z = this.fZP.cze;
        if (!z) {
            this.fZP.cze = true;
            this.fZP.lG(false);
            this.fZP.brt();
            aVar3 = this.fZP.fZH;
            aVar3.brp();
        }
        aVar2 = this.fZP.fZH;
        return aVar2.sc(str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        a aVar;
        a aVar2;
        super.onPageFinished(webView, str);
        this.fZP.cze = true;
        aVar = this.fZP.fZH;
        if (aVar != null) {
            aVar2 = this.fZP.fZH;
            aVar2.brp();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.fZP.lG(false);
        baseActivity = this.fZP.awl;
        baseActivity.showToast(t.j.neterror);
        baseActivity2 = this.fZP.awl;
        baseActivity2.finish();
    }
}
