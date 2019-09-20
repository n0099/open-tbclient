package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes3.dex */
final class a {
    private static final a kad = new a();
    private boolean ac;
    private final Set<InterfaceC0456a> kae = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0456a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cEx() {
        return kad;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0456a> cEy() {
        return this.kae;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0456a interfaceC0456a) {
        synchronized (this.kae) {
            this.kae.add(interfaceC0456a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.kae) {
            this.kae.clear();
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
            com.baidu.ubs.analytics.d.j.HO("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
