package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes15.dex */
final class a {
    private static final a oUp = new a();
    private boolean ac;
    private final Set<InterfaceC0953a> oUq = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC0953a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a eij() {
        return oUp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0953a> eik() {
        return this.oUq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0953a interfaceC0953a) {
        synchronized (this.oUq) {
            this.oUq.add(interfaceC0953a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.oUq) {
            this.oUq.clear();
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
            com.baidu.ubs.analytics.d.j.I("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
