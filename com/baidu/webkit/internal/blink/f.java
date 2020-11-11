package com.baidu.webkit.internal.blink;

import com.baidu.webkit.internal.blink.d;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes11.dex */
final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.b f3932a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d.b bVar) {
        this.f3932a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebViewFactory.getProvider();
        this.f3932a.a();
    }
}
