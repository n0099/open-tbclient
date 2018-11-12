package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
final class a {
    private static final a hVv = new a();
    private boolean ac;
    private final Set<InterfaceC0334a> hVw = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0334a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a bPG() {
        return hVv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0334a> bPH() {
        return this.hVw;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0334a interfaceC0334a) {
        synchronized (this.hVw) {
            this.hVw.add(interfaceC0334a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.hVw) {
            this.hVw.clear();
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
            com.baidu.ubs.analytics.d.j.xY("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
