package com.baidu.webkit.internal.blink;

import com.baidu.webkit.internal.blink.d;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes5.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d.b f26588a;

    public f(d.b bVar) {
        this.f26588a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebViewFactory.getProvider();
        this.f26588a.a();
    }
}
