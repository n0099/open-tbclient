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
    private static Object maO;
    private static Integer maP;
    private static Activity maQ;
    private static c maR;
    private static final Map<Activity, a> maS;
    private static final com.baidu.turbonet.base.b<b> maT;
    private static final com.baidu.turbonet.base.b<c> maU;

    /* loaded from: classes.dex */
    public interface b {
        void m(Activity activity, int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        void FU(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnApplicationStateChange(int i);

    static {
        $assertionsDisabled = !ApplicationStatus.class.desiredAssertionStatus();
        maO = new Object();
        maS = new ConcurrentHashMap();
        maT = new com.baidu.turbonet.base.b<>();
        maU = new com.baidu.turbonet.base.b<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private int mStatus;
        private com.baidu.turbonet.base.b<b> maW;

        private a() {
            this.mStatus = 6;
            this.maW = new com.baidu.turbonet.base.b<>();
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public com.baidu.turbonet.base.b<b> dpM() {
            return this.maW;
        }
    }

    private ApplicationStatus() {
    }

    public static void a(BaseChromiumApplication baseChromiumApplication) {
        baseChromiumApplication.a(new BaseChromiumApplication.b() { // from class: com.baidu.turbonet.base.ApplicationStatus.1
            @Override // com.baidu.turbonet.base.BaseChromiumApplication.b
            public void k(Activity activity, boolean z) {
                int as;
                if (z && activity != ApplicationStatus.maQ && (as = ApplicationStatus.as(activity)) != 6 && as != 5) {
                    Activity unused = ApplicationStatus.maQ = activity;
                }
            }
        });
        baseChromiumApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.baidu.turbonet.base.ApplicationStatus.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                ApplicationStatus.k(activity, 1);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                ApplicationStatus.k(activity, 6);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ApplicationStatus.k(activity, 4);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                ApplicationStatus.k(activity, 3);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ApplicationStatus.k(activity, 2);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                ApplicationStatus.k(activity, 5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(Activity activity, int i) {
        if (activity == null) {
            throw new IllegalArgumentException("null activity is not supported");
        }
        if (maQ == null || i == 1 || i == 3 || i == 2) {
            maQ = activity;
        }
        int stateForApplication = getStateForApplication();
        if (i == 1) {
            if (!$assertionsDisabled && maS.containsKey(activity)) {
                throw new AssertionError();
            }
            maS.put(activity, new a());
        }
        synchronized (maO) {
            maP = null;
        }
        a aVar = maS.get(activity);
        aVar.setStatus(i);
        Iterator<b> it = aVar.dpM().iterator();
        while (it.hasNext()) {
            it.next().m(activity, i);
        }
        Iterator<b> it2 = maT.iterator();
        while (it2.hasNext()) {
            it2.next().m(activity, i);
        }
        int stateForApplication2 = getStateForApplication();
        if (stateForApplication2 != stateForApplication) {
            Iterator<c> it3 = maU.iterator();
            while (it3.hasNext()) {
                it3.next().FU(stateForApplication2);
            }
        }
        if (i == 6) {
            maS.remove(activity);
            if (activity == maQ) {
                maQ = null;
            }
        }
    }

    public static int as(Activity activity) {
        a aVar = maS.get(activity);
        if (aVar != null) {
            return aVar.getStatus();
        }
        return 6;
    }

    @CalledByNative
    public static int getStateForApplication() {
        int intValue;
        synchronized (maO) {
            if (maP == null) {
                maP = Integer.valueOf(dpJ());
            }
            intValue = maP.intValue();
        }
        return intValue;
    }

    public static void a(c cVar) {
        maU.aJ(cVar);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.turbonet.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.maR == null) {
                    c unused = ApplicationStatus.maR = new c() { // from class: com.baidu.turbonet.base.ApplicationStatus.3.1
                        @Override // com.baidu.turbonet.base.ApplicationStatus.c
                        public void FU(int i) {
                            ApplicationStatus.nativeOnApplicationStateChange(i);
                        }
                    };
                    ApplicationStatus.a(ApplicationStatus.maR);
                }
            }
        });
    }

    private static int dpJ() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = false;
        for (a aVar : maS.values()) {
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
