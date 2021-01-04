package com.baidu.webkit.internal.blink;

import com.baidu.webkit.internal.blink.d;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes4.dex */
final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d.b f5959a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d.b bVar) {
        this.f5959a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebViewFactory.getProvider();
        this.f5959a.a();
    }
}
