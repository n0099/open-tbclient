package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes3.dex */
final class a {
    private static final a jwY = new a();
    private boolean ac;
    private final Set<InterfaceC0328a> jwZ = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0328a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a csq() {
        return jwY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0328a> csr() {
        return this.jwZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0328a interfaceC0328a) {
        synchronized (this.jwZ) {
            this.jwZ.add(interfaceC0328a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.jwZ) {
            this.jwZ.clear();
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
            com.baidu.ubs.analytics.d.j.EZ("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
