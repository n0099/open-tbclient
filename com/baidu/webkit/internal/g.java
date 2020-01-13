package com.baidu.webkit.internal;

import com.baidu.webkit.sdk.WebView;
/* loaded from: classes10.dex */
public final class g implements Runnable {
    final /* synthetic */ f a;

    public g(f fVar) {
        this.a = fVar;
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
                webView = this.a.d;
            } catch (Exception e) {
                com.a.a.a.a.a.a.a.a(e);
            }
            if (webView == null) {
                return;
            }
            webView2 = this.a.d;
            if (webView2.isDestroyed()) {
                return;
            }
            this.a.d();
            Thread.sleep(20L);
            i = i2 + 1;
        }
    }
}
