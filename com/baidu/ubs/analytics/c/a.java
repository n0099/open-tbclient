package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes3.dex */
final class a {
    private static final a jPx = new a();
    private boolean ac;
    private final Set<InterfaceC0440a> jPy = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0440a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cAo() {
        return jPx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0440a> cAp() {
        return this.jPy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0440a interfaceC0440a) {
        synchronized (this.jPy) {
            this.jPy.add(interfaceC0440a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.jPy) {
            this.jPy.clear();
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
            com.baidu.ubs.analytics.d.j.Gr("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
