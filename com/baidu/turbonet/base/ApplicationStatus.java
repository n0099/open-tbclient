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
/* loaded from: classes4.dex */
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Object oEf;
    private static Integer oEg;
    private static Activity oEh;
    private static c oEi;
    private static final com.baidu.turbonet.base.b<b> oEj;
    private static final com.baidu.turbonet.base.b<c> oEk;
    private static final Map<Activity, a> sActivityInfo;

    /* loaded from: classes4.dex */
    public interface b {
        void l(Activity activity, int i);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void Mm(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnApplicationStateChange(int i);

    static {
        $assertionsDisabled = !ApplicationStatus.class.desiredAssertionStatus();
        oEf = new Object();
        sActivityInfo = new ConcurrentHashMap();
        oEj = new com.baidu.turbonet.base.b<>();
        oEk = new com.baidu.turbonet.base.b<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private int mStatus;
        private com.baidu.turbonet.base.b<b> oEm;

        private a() {
            this.mStatus = 6;
            this.oEm = new com.baidu.turbonet.base.b<>();
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public com.baidu.turbonet.base.b<b> edw() {
            return this.oEm;
        }
    }

    private ApplicationStatus() {
    }

    public static void a(BaseChromiumApplication baseChromiumApplication) {
        baseChromiumApplication.a(new BaseChromiumApplication.b() { // from class: com.baidu.turbonet.base.ApplicationStatus.1
            @Override // com.baidu.turbonet.base.BaseChromiumApplication.b
            public void m(Activity activity, boolean z) {
                int aI;
                if (z && activity != ApplicationStatus.oEh && (aI = ApplicationStatus.aI(activity)) != 6 && aI != 5) {
                    Activity unused = ApplicationStatus.oEh = activity;
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
        if (oEh == null || i == 1 || i == 3 || i == 2) {
            oEh = activity;
        }
        int stateForApplication = getStateForApplication();
        if (i == 1) {
            if (!$assertionsDisabled && sActivityInfo.containsKey(activity)) {
                throw new AssertionError();
            }
            sActivityInfo.put(activity, new a());
        }
        synchronized (oEf) {
            oEg = null;
        }
        a aVar = sActivityInfo.get(activity);
        aVar.setStatus(i);
        Iterator<b> it = aVar.edw().iterator();
        while (it.hasNext()) {
            it.next().l(activity, i);
        }
        Iterator<b> it2 = oEj.iterator();
        while (it2.hasNext()) {
            it2.next().l(activity, i);
        }
        int stateForApplication2 = getStateForApplication();
        if (stateForApplication2 != stateForApplication) {
            Iterator<c> it3 = oEk.iterator();
            while (it3.hasNext()) {
                it3.next().Mm(stateForApplication2);
            }
        }
        if (i == 6) {
            sActivityInfo.remove(activity);
            if (activity == oEh) {
                oEh = null;
            }
        }
    }

    public static int aI(Activity activity) {
        a aVar = sActivityInfo.get(activity);
        if (aVar != null) {
            return aVar.getStatus();
        }
        return 6;
    }

    @CalledByNative
    public static int getStateForApplication() {
        int intValue;
        synchronized (oEf) {
            if (oEg == null) {
                oEg = Integer.valueOf(edt());
            }
            intValue = oEg.intValue();
        }
        return intValue;
    }

    public static void a(c cVar) {
        oEk.addObserver(cVar);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.turbonet.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.oEi == null) {
                    c unused = ApplicationStatus.oEi = new c() { // from class: com.baidu.turbonet.base.ApplicationStatus.3.1
                        @Override // com.baidu.turbonet.base.ApplicationStatus.c
                        public void Mm(int i) {
                            ApplicationStatus.nativeOnApplicationStateChange(i);
                        }
                    };
                    ApplicationStatus.a(ApplicationStatus.oEi);
                }
            }
        });
    }

    private static int edt() {
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
