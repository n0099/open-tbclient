package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
final class a {
    private static final a kVj = new a();
    private boolean ac;
    private final Set<InterfaceC0634a> kVk = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0634a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cWa() {
        return kVj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0634a> cWb() {
        return this.kVk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0634a interfaceC0634a) {
        synchronized (this.kVk) {
            this.kVk.add(interfaceC0634a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void cWc() {
        synchronized (this.kVk) {
            this.kVk.clear();
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
            com.baidu.ubs.analytics.d.j.Lf("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
