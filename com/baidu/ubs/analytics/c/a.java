package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes8.dex */
final class a {
    private static final a lOt = new a();
    private boolean ac;
    private final Set<InterfaceC0712a> lOu = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0712a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a dkY() {
        return lOt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0712a> dkZ() {
        return this.lOu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0712a interfaceC0712a) {
        synchronized (this.lOu) {
            this.lOu.add(interfaceC0712a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void dla() {
        synchronized (this.lOu) {
            this.lOu.clear();
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
