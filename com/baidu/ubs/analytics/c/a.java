package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes.dex */
final class a {
    private static final a hxH = new a();
    private final Set<InterfaceC0261a> hxI = new LinkedHashSet();
    private boolean hxJ;

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0261a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a bJS() {
        return hxH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0261a> bJT() {
        return this.hxI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0261a interfaceC0261a) {
        synchronized (this.hxI) {
            this.hxI.add(interfaceC0261a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.hxI) {
            this.hxI.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(Context context) {
        if (this.hxJ || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception e) {
            com.baidu.ubs.analytics.d.j.wh("registerActivityLifecycleCallbacks encounter exception");
        }
        this.hxJ = true;
    }
}
