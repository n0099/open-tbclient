package com.baidu.turbonet.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.turbonet.base.BaseChromiumApplication;
import com.baidu.turbonet.base.annotations.CalledByNative;
import com.baidu.turbonet.base.annotations.JNINamespace;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@JNINamespace
/* loaded from: classes.dex */
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Object lHt;
    private static Integer lHu;
    private static Activity lHv;
    private static c lHw;
    private static final Map<Activity, a> lHx;
    private static final com.baidu.turbonet.base.b<b> lHy;
    private static final com.baidu.turbonet.base.b<c> lHz;

    /* loaded from: classes.dex */
    public interface b {
        void n(Activity activity, int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        void Fh(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnApplicationStateChange(int i);

    static {
        $assertionsDisabled = !ApplicationStatus.class.desiredAssertionStatus();
        lHt = new Object();
        lHx = new ConcurrentHashMap();
        lHy = new com.baidu.turbonet.base.b<>();
        lHz = new com.baidu.turbonet.base.b<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private com.baidu.turbonet.base.b<b> lHB;
        private int mStatus;

        private a() {
            this.mStatus = 6;
            this.lHB = new com.baidu.turbonet.base.b<>();
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public com.baidu.turbonet.base.b<b> dix() {
            return this.lHB;
        }
    }

    private ApplicationStatus() {
    }

    public static void a(BaseChromiumApplication baseChromiumApplication) {
        baseChromiumApplication.a(new BaseChromiumApplication.b() { // from class: com.baidu.turbonet.base.ApplicationStatus.1
            @Override // com.baidu.turbonet.base.BaseChromiumApplication.b
            public void k(Activity activity, boolean z) {
                int at;
                if (z && activity != ApplicationStatus.lHv && (at = ApplicationStatus.at(activity)) != 6 && at != 5) {
                    Activity unused = ApplicationStatus.lHv = activity;
                }
            }
        });
        baseChromiumApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.baidu.turbonet.base.ApplicationStatus.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ApplicationStatus.l(activity, 1);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                ApplicationStatus.l(activity, 6);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ApplicationStatus.l(activity, 4);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                ApplicationStatus.l(activity, 3);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ApplicationStatus.l(activity, 2);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ApplicationStatus.l(activity, 5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l(Activity activity, int i) {
        if (activity == null) {
            throw new IllegalArgumentException("null activity is not supported");
        }
        if (lHv == null || i == 1 || i == 3 || i == 2) {
            lHv = activity;
        }
        int stateForApplication = getStateForApplication();
        if (i == 1) {
            if (!$assertionsDisabled && lHx.containsKey(activity)) {
                throw new AssertionError();
            }
            lHx.put(activity, new a());
        }
        synchronized (lHt) {
            lHu = null;
        }
        a aVar = lHx.get(activity);
        aVar.setStatus(i);
        Iterator<b> it = aVar.dix().iterator();
        while (it.hasNext()) {
            it.next().n(activity, i);
        }
        Iterator<b> it2 = lHy.iterator();
        while (it2.hasNext()) {
            it2.next().n(activity, i);
        }
        int stateForApplication2 = getStateForApplication();
        if (stateForApplication2 != stateForApplication) {
            Iterator<c> it3 = lHz.iterator();
            while (it3.hasNext()) {
                it3.next().Fh(stateForApplication2);
            }
        }
        if (i == 6) {
            lHx.remove(activity);
            if (activity == lHv) {
                lHv = null;
            }
        }
    }

    public static int at(Activity activity) {
        a aVar = lHx.get(activity);
        if (aVar != null) {
            return aVar.getStatus();
        }
        return 6;
    }

    @CalledByNative
    public static int getStateForApplication() {
        int intValue;
        synchronized (lHt) {
            if (lHu == null) {
                lHu = Integer.valueOf(diu());
            }
            intValue = lHu.intValue();
        }
        return intValue;
    }

    public static void a(c cVar) {
        lHz.aF(cVar);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.turbonet.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.lHw == null) {
                    c unused = ApplicationStatus.lHw = new c() { // from class: com.baidu.turbonet.base.ApplicationStatus.3.1
                        @Override // com.baidu.turbonet.base.ApplicationStatus.c
                        public void Fh(int i) {
                            ApplicationStatus.nativeOnApplicationStateChange(i);
                        }
                    };
                    ApplicationStatus.a(ApplicationStatus.lHw);
                }
            }
        });
    }

    private static int diu() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = false;
        for (a aVar : lHx.values()) {
            int status = aVar.getStatus();
            if (status != 4 && status != 5 && status != 6) {
                return 1;
            }
            if (status == 4) {
                z = z3;
                z2 = true;
            } else if (status == 5) {
                z = true;
                z2 = z4;
            } else {
                z = z3;
                z2 = z4;
            }
            z4 = z2;
            z3 = z;
        }
        if (z4) {
            return 2;
        }
        return z3 ? 3 : 4;
    }
}
