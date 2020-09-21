package com.baidu.webkit.internal;

import com.baidu.webkit.sdk.WebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class f implements Runnable {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView;
        WebView webView2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 100) {
                return;
            }
            try {
                webView = this.a.c;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (webView == null) {
                return;
            }
            webView2 = this.a.c;
            if (webView2.isDestroyed()) {
                return;
            }
            this.a.e();
            Thread.sleep(20L);
            i = i2 + 1;
        }
    }
}
