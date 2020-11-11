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
/* loaded from: classes17.dex */
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Object okp;
    private static Integer okq;
    private static Activity okr;
    private static c oks;
    private static final Map<Activity, a> okt;
    private static final com.baidu.turbonet.base.b<b> oku;
    private static final com.baidu.turbonet.base.b<c> okv;

    /* loaded from: classes17.dex */
    public interface b {
        void k(Activity activity, int i);
    }

    /* loaded from: classes17.dex */
    public interface c {
        void ME(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnApplicationStateChange(int i);

    static {
        $assertionsDisabled = !ApplicationStatus.class.desiredAssertionStatus();
        okp = new Object();
        okt = new ConcurrentHashMap();
        oku = new com.baidu.turbonet.base.b<>();
        okv = new com.baidu.turbonet.base.b<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
    public static class a {
        private int mStatus;
        private com.baidu.turbonet.base.b<b> okx;

        private a() {
            this.mStatus = 6;
            this.okx = new com.baidu.turbonet.base.b<>();
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public com.baidu.turbonet.base.b<b> ebd() {
            return this.okx;
        }
    }

    private ApplicationStatus() {
    }

    public static void a(BaseChromiumApplication baseChromiumApplication) {
        baseChromiumApplication.a(new BaseChromiumApplication.b() { // from class: com.baidu.turbonet.base.ApplicationStatus.1
            @Override // com.baidu.turbonet.base.BaseChromiumApplication.b
            public void m(Activity activity, boolean z) {
                int aE;
                if (z && activity != ApplicationStatus.okr && (aE = ApplicationStatus.aE(activity)) != 6 && aE != 5) {
                    Activity unused = ApplicationStatus.okr = activity;
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
        if (okr == null || i == 1 || i == 3 || i == 2) {
            okr = activity;
        }
        int stateForApplication = getStateForApplication();
        if (i == 1) {
            if (!$assertionsDisabled && okt.containsKey(activity)) {
                throw new AssertionError();
            }
            okt.put(activity, new a());
        }
        synchronized (okp) {
            okq = null;
        }
        a aVar = okt.get(activity);
        aVar.setStatus(i);
        Iterator<b> it = aVar.ebd().iterator();
        while (it.hasNext()) {
            it.next().k(activity, i);
        }
        Iterator<b> it2 = oku.iterator();
        while (it2.hasNext()) {
            it2.next().k(activity, i);
        }
        int stateForApplication2 = getStateForApplication();
        if (stateForApplication2 != stateForApplication) {
            Iterator<c> it3 = okv.iterator();
            while (it3.hasNext()) {
                it3.next().ME(stateForApplication2);
            }
        }
        if (i == 6) {
            okt.remove(activity);
            if (activity == okr) {
                okr = null;
            }
        }
    }

    public static int aE(Activity activity) {
        a aVar = okt.get(activity);
        if (aVar != null) {
            return aVar.getStatus();
        }
        return 6;
    }

    @CalledByNative
    public static int getStateForApplication() {
        int intValue;
        synchronized (okp) {
            if (okq == null) {
                okq = Integer.valueOf(eba());
            }
            intValue = okq.intValue();
        }
        return intValue;
    }

    public static void a(c cVar) {
        okv.aS(cVar);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.turbonet.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.oks == null) {
                    c unused = ApplicationStatus.oks = new c() { // from class: com.baidu.turbonet.base.ApplicationStatus.3.1
                        @Override // com.baidu.turbonet.base.ApplicationStatus.c
                        public void ME(int i) {
                            ApplicationStatus.nativeOnApplicationStateChange(i);
                        }
                    };
                    ApplicationStatus.a(ApplicationStatus.oks);
                }
            }
        });
    }

    private static int eba() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = false;
        for (a aVar : okt.values()) {
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
