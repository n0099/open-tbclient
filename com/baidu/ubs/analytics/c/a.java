package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes2.dex */
final class a {
    private static final a hCt = new a();
    private final Set<InterfaceC0263a> hCu = new LinkedHashSet();
    private boolean hCv;

    /* renamed from: com.baidu.ubs.analytics.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0263a {
        void T();

        void U();

        void a(Activity activity);

        void onActivityDestroyed(Activity activity);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a bIX() {
        return hCt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<InterfaceC0263a> bIY() {
        return this.hCu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(InterfaceC0263a interfaceC0263a) {
        synchronized (this.hCu) {
            this.hCu.add(interfaceC0263a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void S() {
        synchronized (this.hCu) {
            this.hCu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(Context context) {
        if (this.hCv || Build.VERSION.SDK_INT < 14) {
            return;
        }
        try {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new h(this));
        } catch (Exception e) {
            com.baidu.ubs.analytics.d.j.we("registerActivityLifecycleCallbacks encounter exception");
        }
        this.hCv = true;
    }
}
