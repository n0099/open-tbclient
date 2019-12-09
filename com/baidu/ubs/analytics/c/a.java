package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes3.dex */
final class a {
    private static final a jXl = new a();
    private boolean ac;
    private final Set<InterfaceC0546a> jXm = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0546a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cBf() {
        return jXl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0546a> cBg() {
        return this.jXm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0546a interfaceC0546a) {
        synchronized (this.jXm) {
            this.jXm.add(interfaceC0546a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void cBh() {
        synchronized (this.jXm) {
            this.jXm.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(Context context) {
        if (this.ac || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception e) {
            com.baidu.ubs.analytics.d.j.Gf("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
