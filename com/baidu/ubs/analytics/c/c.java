package com.baidu.ubs.analytics.c;

import android.app.Activity;
import com.baidu.ubs.analytics.c.a;
import com.baidu.ubs.analytics.c.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public final class c implements a.InterfaceC0445a {
    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void T() {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void U() {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void onActivityDestroyed(Activity activity) {
        d dVar;
        dVar = d.a.jXL;
        dVar.b(activity);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0445a
    public final void a(Activity activity) {
        d dVar;
        dVar = d.a.jXL;
        dVar.a(new WeakReference<>(activity));
    }
}
