package com.bytedance.embedapplog;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;
/* loaded from: classes4.dex */
public class bs implements Application.ActivityLifecycleCallbacks {
    private static long d;
    private static String e;
    private static long f;
    private static String g;
    private static Object i;
    private static Object j;
    private static aj pcN;
    private static aj pcO;
    private final j pcP;

    /* renamed from: a  reason: collision with root package name */
    private static int f5811a = 0;
    private static int h = -1;
    private static final HashSet<Integer> pcQ = new HashSet<>(8);

    public bs(j jVar) {
        this.pcP = jVar;
    }

    public static void b(Object obj) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        pcN = b(activity.getClass().getName(), "", System.currentTimeMillis(), e);
        pcN.k = !pcQ.remove(Integer.valueOf(activity.hashCode())) ? 1 : 0;
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
        if (pcO != null) {
            b(j);
        }
        if (pcN != null) {
            e = pcN.j;
            d = System.currentTimeMillis();
            a(pcN, d);
            pcN = null;
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
        ajVar.f5774a = j2;
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
        ajVar2.f5774a = j2;
        long j3 = j2 - ajVar.f5774a;
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
        f5811a++;
        if (f5811a == 1 && this.pcP != null) {
            this.pcP.show(true);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (e != null) {
            f5811a--;
            if (f5811a <= 0) {
                e = null;
                g = null;
                f = 0L;
                d = 0L;
                if (this.pcP != null) {
                    this.pcP.show(false);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        pcQ.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        pcQ.add(Integer.valueOf(activity.hashCode()));
    }
}
