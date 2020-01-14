package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
final class a {
    private static final a kVo = new a();
    private boolean ac;
    private final Set<InterfaceC0634a> kVp = new LinkedHashSet();

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
    public static a cWc() {
        return kVo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0634a> cWd() {
        return this.kVp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0634a interfaceC0634a) {
        synchronized (this.kVp) {
            this.kVp.add(interfaceC0634a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void cWe() {
        synchronized (this.kVp) {
            this.kVp.clear();
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
