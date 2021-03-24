package com.baidu.webkit.internal;

import com.baidu.webkit.sdk.WebView;
/* loaded from: classes5.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f26927a;

    public f(e eVar) {
        this.f26927a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView;
        WebView webView2;
        for (int i = 0; i < 100; i++) {
            try {
                webView = this.f26927a.f26921c;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (webView == null) {
                return;
            }
            webView2 = this.f26927a.f26921c;
            if (webView2.isDestroyed()) {
                return;
            }
            this.f26927a.e();
            Thread.sleep(20L);
        }
    }
}
