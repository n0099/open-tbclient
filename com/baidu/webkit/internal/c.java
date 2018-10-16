package com.baidu.webkit.internal;

import com.baidu.webkit.sdk.WebView;
/* loaded from: classes2.dex */
public final class c implements Runnable {
    final /* synthetic */ b a;

    public c(b bVar) {
        this.a = bVar;
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
