package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes8.dex */
final class a {
    private static final a mEQ = new a();
    private boolean ac;
    private final Set<InterfaceC0786a> mER = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0786a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a dxl() {
        return mEQ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0786a> dxm() {
        return this.mER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0786a interfaceC0786a) {
        synchronized (this.mER) {
            this.mER.add(interfaceC0786a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.mER) {
            this.mER.clear();
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
