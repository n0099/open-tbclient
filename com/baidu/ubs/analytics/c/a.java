package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
final class a {
    private static final a iha = new a();
    private boolean ac;
    private final Set<InterfaceC0347a> ihb = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0347a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a bTk() {
        return iha;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0347a> bTl() {
        return this.ihb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0347a interfaceC0347a) {
        synchronized (this.ihb) {
            this.ihb.add(interfaceC0347a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.ihb) {
            this.ihb.clear();
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
            com.baidu.ubs.analytics.d.j.yU("registerActivityLifecycleCallbacks encounter exception");
        }
        this.ac = true;
    }
}
