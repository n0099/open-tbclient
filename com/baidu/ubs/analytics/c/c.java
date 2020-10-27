package com.baidu.ubs.analytics.c;

import android.app.Activity;
import com.baidu.ubs.analytics.c.a;
import com.baidu.ubs.analytics.c.d;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public final class c implements a.InterfaceC0914a {
    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0914a
    public final void T() {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0914a
    public final void U() {
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0914a
    public final void onActivityDestroyed(Activity activity) {
        d dVar;
        dVar = d.a.oin;
        dVar.b(activity);
    }

    @Override // com.baidu.ubs.analytics.c.a.InterfaceC0914a
    public final void a(Activity activity) {
        d dVar;
        dVar = d.a.oin;
        dVar.a(new WeakReference<>(activity));
    }
}
