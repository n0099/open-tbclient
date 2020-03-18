package com.baidu.ubs.analytics.c;

import android.app.Activity;
import com.baidu.ubs.analytics.c.a;
import com.baidu.ubs.analytics.c.d;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public final class c implements a.InterfaceC0643a {
    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0643a
    public final void T() {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0643a
    public final void U() {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0643a
    public final void onActivityDestroyed(Activity activity) {
        d dVar;
        dVar = d.a.kXQ;
        dVar.b(activity);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0643a
    public final void a(Activity activity) {
        d dVar;
        dVar = d.a.kXQ;
        dVar.a(new WeakReference<>(activity));
    }
}
