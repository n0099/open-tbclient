package com.baidu.webkit.internal.blink;

import com.baidu.webkit.internal.blink.d;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes19.dex */
final class f implements Runnable {
    final /* synthetic */ d.b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d.b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebViewFactory.getProvider();
        this.a.a();
    }
}
