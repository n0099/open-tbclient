package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes.dex */
final class a {
    private static final a hkL = new a();
    private final Set<InterfaceC0244a> hkM = new LinkedHashSet();
    private boolean hkN;

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0244a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a bEQ() {
        return hkL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0244a> bER() {
        return this.hkM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0244a interfaceC0244a) {
        synchronized (this.hkM) {
            this.hkM.add(interfaceC0244a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.hkM) {
            this.hkM.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(Context context) {
        if (this.hkN || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception e) {
            com.baidu.ubs.analytics.d.j.vk("registerActivityLifecycleCallbacks encounter exception");
        }
        this.hkN = true;
    }
}
