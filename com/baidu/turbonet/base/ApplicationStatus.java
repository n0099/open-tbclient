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
/* loaded from: classes6.dex */
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Object oOo;
    private static Integer oOp;
    private static Activity oOq;
    private static c oOr;
    private static final com.baidu.turbonet.base.b<b> oOs;
    private static final com.baidu.turbonet.base.b<c> oOt;
    private static final Map<Activity, a> sActivityInfo;

    /* loaded from: classes6.dex */
    public interface b {
        void l(Activity activity, int i);
    }

    /* loaded from: classes6.dex */
    public interface c {
        void MI(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnApplicationStateChange(int i);

    static {
        $assertionsDisabled = !ApplicationStatus.class.desiredAssertionStatus();
        oOo = new Object();
        sActivityInfo = new ConcurrentHashMap();
        oOs = new com.baidu.turbonet.base.b<>();
        oOt = new com.baidu.turbonet.base.b<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private int mStatus;
        private com.baidu.turbonet.base.b<b> oOv;

        private a() {
            this.mStatus = 6;
            this.oOv = new com.baidu.turbonet.base.b<>();
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public com.baidu.turbonet.base.b<b> efO() {
            return this.oOv;
        }
    }

    private ApplicationStatus() {
    }

    public static void a(BaseChromiumApplication baseChromiumApplication) {
        baseChromiumApplication.a(new BaseChromiumApplication.b() { // from class: com.baidu.turbonet.base.ApplicationStatus.1
            @Override // com.baidu.turbonet.base.BaseChromiumApplication.b
            public void m(Activity activity, boolean z) {
                int aB;
                if (z && activity != ApplicationStatus.oOq && (aB = ApplicationStatus.aB(activity)) != 6 && aB != 5) {
                    Activity unused = ApplicationStatus.oOq = activity;
                }
            }
        });
        baseChromiumApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.baidu.turbonet.base.ApplicationStatus.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ApplicationStatus.j(activity, 1);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                ApplicationStatus.j(activity, 6);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ApplicationStatus.j(activity, 4);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                ApplicationStatus.j(activity, 3);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ApplicationStatus.j(activity, 2);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ApplicationStatus.j(activity, 5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j(Activity activity, int i) {
        if (activity == null) {
            throw new IllegalArgumentException("null activity is not supported");
        }
        if (oOq == null || i == 1 || i == 3 || i == 2) {
            oOq = activity;
        }
        int stateForApplication = getStateForApplication();
        if (i == 1) {
            if (!$assertionsDisabled && sActivityInfo.containsKey(activity)) {
                throw new AssertionError();
            }
            sActivityInfo.put(activity, new a());
        }
        synchronized (oOo) {
            oOp = null;
        }
        a aVar = sActivityInfo.get(activity);
        aVar.setStatus(i);
        Iterator<b> it = aVar.efO().iterator();
        while (it.hasNext()) {
            it.next().l(activity, i);
        }
        Iterator<b> it2 = oOs.iterator();
        while (it2.hasNext()) {
            it2.next().l(activity, i);
        }
        int stateForApplication2 = getStateForApplication();
        if (stateForApplication2 != stateForApplication) {
            Iterator<c> it3 = oOt.iterator();
            while (it3.hasNext()) {
                it3.next().MI(stateForApplication2);
            }
        }
        if (i == 6) {
            sActivityInfo.remove(activity);
            if (activity == oOq) {
                oOq = null;
            }
        }
    }

    public static int aB(Activity activity) {
        a aVar = sActivityInfo.get(activity);
        if (aVar != null) {
            return aVar.getStatus();
        }
        return 6;
    }

    @CalledByNative
    public static int getStateForApplication() {
        int intValue;
        synchronized (oOo) {
            if (oOp == null) {
                oOp = Integer.valueOf(efL());
            }
            intValue = oOp.intValue();
        }
        return intValue;
    }

    public static void a(c cVar) {
        oOt.addObserver(cVar);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.turbonet.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.oOr == null) {
                    c unused = ApplicationStatus.oOr = new c() { // from class: com.baidu.turbonet.base.ApplicationStatus.3.1
                        @Override // com.baidu.turbonet.base.ApplicationStatus.c
                        public void MI(int i) {
                            ApplicationStatus.nativeOnApplicationStateChange(i);
                        }
                    };
                    ApplicationStatus.a(ApplicationStatus.oOr);
                }
            }
        });
    }

    private static int efL() {
        boolean z;
        boolean z2 = false;
        boolean z3 = false;
        for (a aVar : sActivityInfo.values()) {
            int status = aVar.getStatus();
            if (status != 4 && status != 5 && status != 6) {
                return 1;
            }
            if (status == 4) {
                z = z2;
                z3 = true;
            } else {
                z = status == 5 ? true : z2;
            }
            z2 = z;
        }
        if (z3) {
            return 2;
        }
        return z2 ? 3 : 4;
    }
}
