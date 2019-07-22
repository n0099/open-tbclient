package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes3.dex */
final class a {
    private static final a jWA = new a();
    private boolean ac;
    private final Set<InterfaceC0439a> jWB = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0439a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a cDo() {
        return jWA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0439a> cDp() {
        return this.jWB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0439a interfaceC0439a) {
        synchronized (this.jWB) {
            this.jWB.add(interfaceC0439a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.jWB) {
            this.jWB.clear();
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
            com.baidu.ubs.analytics.d.j.Hn("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
