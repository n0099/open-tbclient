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
/* loaded from: classes15.dex */
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Object njn;
    private static Integer njo;
    private static Activity njp;
    private static c njq;
    private static final Map<Activity, a> njr;
    private static final com.baidu.turbonet.base.b<b> njs;
    private static final com.baidu.turbonet.base.b<c> njt;

    /* loaded from: classes15.dex */
    public interface b {
        void k(Activity activity, int i);
    }

    /* loaded from: classes15.dex */
    public interface c {
        void KD(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnApplicationStateChange(int i);

    static {
        $assertionsDisabled = !ApplicationStatus.class.desiredAssertionStatus();
        njn = new Object();
        njr = new ConcurrentHashMap();
        njs = new com.baidu.turbonet.base.b<>();
        njt = new com.baidu.turbonet.base.b<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a {
        private int mStatus;
        private com.baidu.turbonet.base.b<b> njv;

        private a() {
            this.mStatus = 6;
            this.njv = new com.baidu.turbonet.base.b<>();
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public com.baidu.turbonet.base.b<b> dNR() {
            return this.njv;
        }
    }

    private ApplicationStatus() {
    }

    public static void a(BaseChromiumApplication baseChromiumApplication) {
        baseChromiumApplication.a(new BaseChromiumApplication.b() { // from class: com.baidu.turbonet.base.ApplicationStatus.1
            @Override // com.baidu.turbonet.base.BaseChromiumApplication.b
            public void m(Activity activity, boolean z) {
                int ay;
                if (z && activity != ApplicationStatus.njp && (ay = ApplicationStatus.ay(activity)) != 6 && ay != 5) {
                    Activity unused = ApplicationStatus.njp = activity;
                }
            }
        });
        baseChromiumApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.baidu.turbonet.base.ApplicationStatus.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ApplicationStatus.i(activity, 1);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                ApplicationStatus.i(activity, 6);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ApplicationStatus.i(activity, 4);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                ApplicationStatus.i(activity, 3);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ApplicationStatus.i(activity, 2);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ApplicationStatus.i(activity, 5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(Activity activity, int i) {
        if (activity == null) {
            throw new IllegalArgumentException("null activity is not supported");
        }
        if (njp == null || i == 1 || i == 3 || i == 2) {
            njp = activity;
        }
        int stateForApplication = getStateForApplication();
        if (i == 1) {
            if (!$assertionsDisabled && njr.containsKey(activity)) {
                throw new AssertionError();
            }
            njr.put(activity, new a());
        }
        synchronized (njn) {
            njo = null;
        }
        a aVar = njr.get(activity);
        aVar.setStatus(i);
        Iterator<b> it = aVar.dNR().iterator();
        while (it.hasNext()) {
            it.next().k(activity, i);
        }
        Iterator<b> it2 = njs.iterator();
        while (it2.hasNext()) {
            it2.next().k(activity, i);
        }
        int stateForApplication2 = getStateForApplication();
        if (stateForApplication2 != stateForApplication) {
            Iterator<c> it3 = njt.iterator();
            while (it3.hasNext()) {
                it3.next().KD(stateForApplication2);
            }
        }
        if (i == 6) {
            njr.remove(activity);
            if (activity == njp) {
                njp = null;
            }
        }
    }

    public static int ay(Activity activity) {
        a aVar = njr.get(activity);
        if (aVar != null) {
            return aVar.getStatus();
        }
        return 6;
    }

    @CalledByNative
    public static int getStateForApplication() {
        int intValue;
        synchronized (njn) {
            if (njo == null) {
                njo = Integer.valueOf(dNO());
            }
            intValue = njo.intValue();
        }
        return intValue;
    }

    public static void a(c cVar) {
        njt.aO(cVar);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.turbonet.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.njq == null) {
                    c unused = ApplicationStatus.njq = new c() { // from class: com.baidu.turbonet.base.ApplicationStatus.3.1
                        @Override // com.baidu.turbonet.base.ApplicationStatus.c
                        public void KD(int i) {
                            ApplicationStatus.nativeOnApplicationStateChange(i);
                        }
                    };
                    ApplicationStatus.a(ApplicationStatus.njq);
                }
            }
        });
    }

    private static int dNO() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = false;
        for (a aVar : njr.values()) {
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
