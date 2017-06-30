package com.baidu.tieba.write.accountAccess;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends WebViewClient {
    final /* synthetic */ c geh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.geh = cVar;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        if (!StringUtils.isNull(str)) {
            aVar = this.geh.gea;
            if (aVar != null) {
                z = this.geh.onPageFinishHasBeenCalled;
                if (z) {
                    aVar2 = this.geh.gea;
                    return aVar2.sb(str);
                }
                this.geh.onPageFinishHasBeenCalled = true;
                this.geh.showWebLoadingView(false);
                this.geh.brH();
                aVar3 = this.geh.gea;
                aVar3.brE();
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
        this.geh.onPageFinishHasBeenCalled = true;
        aVar = this.geh.gea;
        if (aVar != null) {
            aVar2 = this.geh.gea;
            aVar2.brE();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        super.onReceivedError(webView, i, str, str2);
        this.geh.showWebLoadingView(false);
        baseActivity = this.geh.mContext;
        baseActivity.showToast(w.l.neterror);
        baseActivity2 = this.geh.mContext;
        baseActivity2.finish();
    }
}
