package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes5.dex */
final class a {
    private static final a nfS = new a();
    private boolean ac;
    private final Set<InterfaceC0849a> nfT = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0849a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a dMl() {
        return nfS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0849a> dMm() {
        return this.nfT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0849a interfaceC0849a) {
        synchronized (this.nfT) {
            this.nfT.add(interfaceC0849a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.nfT) {
            this.nfT.clear();
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
