package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c gjD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.gjD = cVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        if (!StringUtils.isNull(str)) {
            aVar = this.gjD.gjv;
            if (aVar != null) {
                z = this.gjD.cES;
                if (z) {
                    aVar2 = this.gjD.gjv;
                    return aVar2.sN(str);
                }
                this.gjD.cES = true;
                this.gjD.mh(false);
                this.gjD.buu();
                aVar3 = this.gjD.gjv;
                aVar3.buq();
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
        this.gjD.cES = true;
        aVar = this.gjD.gjv;
        if (aVar != null) {
            aVar2 = this.gjD.gjv;
            aVar2.buq();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.gjD.mh(false);
        baseActivity = this.gjD.awH;
        baseActivity.showToast(r.j.neterror);
        baseActivity2 = this.gjD.awH;
        baseActivity2.finish();
    }
}
