package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes17.dex */
final class a {
    private static final a oIc = new a();
    private boolean ac;
    private final Set<InterfaceC0950a> oId = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC0950a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a ejr() {
        return oIc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0950a> ejs() {
        return this.oId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0950a interfaceC0950a) {
        synchronized (this.oId) {
            this.oId.add(interfaceC0950a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.oId) {
            this.oId.clear();
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
