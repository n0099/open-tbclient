package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes2.dex */
final class a {
    private static final a hKS = new a();
    private boolean ac;
    private final Set<InterfaceC0269a> hKT = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0269a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a bLS() {
        return hKS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0269a> bLT() {
        return this.hKT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0269a interfaceC0269a) {
        synchronized (this.hKT) {
            this.hKT.add(interfaceC0269a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.hKT) {
            this.hKT.clear();
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
            com.baidu.ubs.analytics.d.j.wT("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
