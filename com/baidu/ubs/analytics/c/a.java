package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes.dex */
final class a {
    private static final a hlM = new a();
    private final Set<InterfaceC0244a> hlN = new LinkedHashSet();
    private boolean hlO;

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
    public static a bEO() {
        return hlM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0244a> bEP() {
        return this.hlN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0244a interfaceC0244a) {
        synchronized (this.hlN) {
            this.hlN.add(interfaceC0244a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.hlN) {
            this.hlN.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(Context context) {
        if (this.hlO || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception e) {
            com.baidu.ubs.analytics.d.j.vn("registerActivityLifecycleCallbacks encounter exception");
        }
        this.hlO = true;
    }
}
