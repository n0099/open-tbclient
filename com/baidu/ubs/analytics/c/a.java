package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes8.dex */
final class a {
    private static final a kXL = new a();
    private boolean ac;
    private final Set<InterfaceC0643a> kXM = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0643a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cXR() {
        return kXL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0643a> cXS() {
        return this.kXM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0643a interfaceC0643a) {
        synchronized (this.kXM) {
            this.kXM.add(interfaceC0643a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void cXT() {
        synchronized (this.kXM) {
            this.kXM.clear();
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
            com.baidu.ubs.analytics.d.j.Lt("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
