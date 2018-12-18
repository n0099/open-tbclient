package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
final class a {
    private static final a icF = new a();
    private boolean ac;
    private final Set<InterfaceC0348a> icG = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0348a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a bRL() {
        return icF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0348a> bRM() {
        return this.icG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0348a interfaceC0348a) {
        synchronized (this.icG) {
            this.icG.add(interfaceC0348a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.icG) {
            this.icG.clear();
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
            com.baidu.ubs.analytics.d.j.yB("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
