package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c gbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.gbY = cVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        if (!StringUtils.isNull(str)) {
            aVar = this.gbY.gbQ;
            if (aVar != null) {
                z = this.gbY.czI;
                if (z) {
                    aVar2 = this.gbY.gbQ;
                    return aVar2.sr(str);
                }
                this.gbY.czI = true;
                this.gbY.lI(false);
                this.gbY.brZ();
                aVar3 = this.gbY.gbQ;
                aVar3.brV();
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
        this.gbY.czI = true;
        aVar = this.gbY.gbQ;
        if (aVar != null) {
            aVar2 = this.gbY.gbQ;
            aVar2.brV();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.gbY.lI(false);
        baseActivity = this.gbY.avO;
        baseActivity.showToast(r.j.neterror);
        baseActivity2 = this.gbY.avO;
        baseActivity2.finish();
    }
}
