package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes8.dex */
final class a {
    private static final a lOp = new a();
    private boolean ac;
    private final Set<InterfaceC0691a> lOq = new LinkedHashSet();

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0691a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a dla() {
        return lOp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0691a> dlb() {
        return this.lOq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0691a interfaceC0691a) {
        synchronized (this.lOq) {
            this.lOq.add(interfaceC0691a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void dlc() {
        synchronized (this.lOq) {
            this.lOq.clear();
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
