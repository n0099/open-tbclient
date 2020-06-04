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
    private static Object mbY;
    private static Integer mbZ;
    private static Activity mca;
    private static c mcb;
    private static final Map<Activity, a> mcc;
    private static final com.baidu.turbonet.base.b<b> mcd;
    private static final com.baidu.turbonet.base.b<c> mce;

    /* loaded from: classes.dex */
    public interface b {
        void m(Activity activity, int i);
    }

    /* loaded from: classes.dex */
    public interface c {
        void FW(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnApplicationStateChange(int i);

    static {
        $assertionsDisabled = !ApplicationStatus.class.desiredAssertionStatus();
        mbY = new Object();
        mcc = new ConcurrentHashMap();
        mcd = new com.baidu.turbonet.base.b<>();
        mce = new com.baidu.turbonet.base.b<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        private int mStatus;
        private com.baidu.turbonet.base.b<b> mcg;

        private a() {
            this.mStatus = 6;
            this.mcg = new com.baidu.turbonet.base.b<>();
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public com.baidu.turbonet.base.b<b> dqa() {
            return this.mcg;
        }
    }

    private ApplicationStatus() {
    }

    public static void a(BaseChromiumApplication baseChromiumApplication) {
        baseChromiumApplication.a(new BaseChromiumApplication.b() { // from class: com.baidu.turbonet.base.ApplicationStatus.1
            @Override // com.baidu.turbonet.base.BaseChromiumApplication.b
            public void k(Activity activity, boolean z) {
                int as;
                if (z && activity != ApplicationStatus.mca && (as = ApplicationStatus.as(activity)) != 6 && as != 5) {
                    Activity unused = ApplicationStatus.mca = activity;
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
        if (mca == null || i == 1 || i == 3 || i == 2) {
            mca = activity;
        }
        int stateForApplication = getStateForApplication();
        if (i == 1) {
            if (!$assertionsDisabled && mcc.containsKey(activity)) {
                throw new AssertionError();
            }
            mcc.put(activity, new a());
        }
        synchronized (mbY) {
            mbZ = null;
        }
        a aVar = mcc.get(activity);
        aVar.setStatus(i);
        Iterator<b> it = aVar.dqa().iterator();
        while (it.hasNext()) {
            it.next().m(activity, i);
        }
        Iterator<b> it2 = mcd.iterator();
        while (it2.hasNext()) {
            it2.next().m(activity, i);
        }
        int stateForApplication2 = getStateForApplication();
        if (stateForApplication2 != stateForApplication) {
            Iterator<c> it3 = mce.iterator();
            while (it3.hasNext()) {
                it3.next().FW(stateForApplication2);
            }
        }
        if (i == 6) {
            mcc.remove(activity);
            if (activity == mca) {
                mca = null;
            }
        }
    }

    public static int as(Activity activity) {
        a aVar = mcc.get(activity);
        if (aVar != null) {
            return aVar.getStatus();
        }
        return 6;
    }

    @CalledByNative
    public static int getStateForApplication() {
        int intValue;
        synchronized (mbY) {
            if (mbZ == null) {
                mbZ = Integer.valueOf(dpX());
            }
            intValue = mbZ.intValue();
        }
        return intValue;
    }

    public static void a(c cVar) {
        mce.aJ(cVar);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.turbonet.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.mcb == null) {
                    c unused = ApplicationStatus.mcb = new c() { // from class: com.baidu.turbonet.base.ApplicationStatus.3.1
                        @Override // com.baidu.turbonet.base.ApplicationStatus.c
                        public void FW(int i) {
                            ApplicationStatus.nativeOnApplicationStateChange(i);
                        }
                    };
                    ApplicationStatus.a(ApplicationStatus.mcb);
                }
            }
        });
    }

    private static int dpX() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = false;
        for (a aVar : mcc.values()) {
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
