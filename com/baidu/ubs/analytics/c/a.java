package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes7.dex */
final class a {
    private static final a nqm = new a();
    private boolean ac;
    private final Set<InterfaceC0846a> nqn = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0846a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a dQs() {
        return nqm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0846a> dQt() {
        return this.nqn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0846a interfaceC0846a) {
        synchronized (this.nqn) {
            this.nqn.add(interfaceC0846a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.nqn) {
            this.nqn.clear();
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
