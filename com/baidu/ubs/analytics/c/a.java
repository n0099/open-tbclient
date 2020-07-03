package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes8.dex */
final class a {
    private static final a mEN = new a();
    private boolean ac;
    private final Set<InterfaceC0785a> mEO = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0785a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a dxh() {
        return mEN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0785a> dxi() {
        return this.mEO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0785a interfaceC0785a) {
        synchronized (this.mEO) {
            this.mEO.add(interfaceC0785a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.mEO) {
            this.mEO.clear();
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
