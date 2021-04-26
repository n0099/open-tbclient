package com.baidu.webkit.internal;

import com.baidu.webkit.sdk.WebView;
/* loaded from: classes5.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e f27429a;

    public f(e eVar) {
        this.f27429a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView;
        WebView webView2;
        for (int i2 = 0; i2 < 100; i2++) {
            try {
                webView = this.f27429a.f27422c;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (webView == null) {
                return;
            }
            webView2 = this.f27429a.f27422c;
            if (webView2.isDestroyed()) {
                return;
            }
            this.f27429a.e();
            Thread.sleep(20L);
        }
    }
}
