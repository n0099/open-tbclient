package com.bytedance.embedapplog;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;
/* loaded from: classes6.dex */
public class bs implements Application.ActivityLifecycleCallbacks {
    private static long d;
    private static String e;
    private static long f;
    private static String g;
    private static Object i;
    private static Object j;
    private static aj pnb;
    private static aj pnc;
    private final j pnd;

    /* renamed from: a  reason: collision with root package name */
    private static int f5813a = 0;
    private static int h = -1;
    private static final HashSet<Integer> pne = new HashSet<>(8);

    public bs(j jVar) {
        this.pnd = jVar;
    }

    public static void b(Object obj) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        pnb = b(activity.getClass().getName(), "", System.currentTimeMillis(), e);
        pnb.k = !pne.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
        if (!activity.isChild()) {
            try {
                h = activity.getWindow().getDecorView().hashCode();
                i = activity;
            } catch (Exception e2) {
                au.a(e2);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (pnc != null) {
            b(j);
        }
        if (pnb != null) {
            e = pnb.j;
            d = System.currentTimeMillis();
            a(pnb, d);
            pnb = null;
            if (!activity.isChild()) {
                h = -1;
                i = null;
            }
        }
    }

    public static aj b(String str, String str2, long j2, String str3) {
        aj ajVar = new aj();
        if (!TextUtils.isEmpty(str2)) {
            ajVar.j = str + ":" + str2;
        } else {
            ajVar.j = str;
        }
        ajVar.f5776a = j2;
        ajVar.h = -1L;
        if (str3 == null) {
            str3 = "";
        }
        ajVar.i = str3;
        bx.a(ajVar);
        return ajVar;
    }

    public static aj a(aj ajVar, long j2) {
        aj ajVar2 = (aj) ajVar.clone();
        ajVar2.f5776a = j2;
        long j3 = j2 - ajVar.f5776a;
        if (j3 >= 0) {
            ajVar2.h = j3;
        } else {
            au.a(null);
        }
        bx.a(ajVar2);
        return ajVar2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        f5813a++;
        if (f5813a == 1 && this.pnd != null) {
            this.pnd.show(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (e != null) {
            f5813a--;
            if (f5813a <= 0) {
                e = null;
                g = null;
                f = 0L;
                d = 0L;
                if (this.pnd != null) {
                    this.pnd.show(false);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        pne.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        pne.add(Integer.valueOf(activity.hashCode()));
    }
}
