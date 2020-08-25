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
/* loaded from: classes10.dex */
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Object mYW;
    private static Integer mYX;
    private static Activity mYY;
    private static c mYZ;
    private static final Map<Activity, a> mZa;
    private static final com.baidu.turbonet.base.b<b> mZb;
    private static final com.baidu.turbonet.base.b<c> mZc;

    /* loaded from: classes10.dex */
    public interface b {
        void l(Activity activity, int i);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void JY(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnApplicationStateChange(int i);

    static {
        $assertionsDisabled = !ApplicationStatus.class.desiredAssertionStatus();
        mYW = new Object();
        mZa = new ConcurrentHashMap();
        mZb = new com.baidu.turbonet.base.b<>();
        mZc = new com.baidu.turbonet.base.b<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private int mStatus;
        private com.baidu.turbonet.base.b<b> mZe;

        private a() {
            this.mStatus = 6;
            this.mZe = new com.baidu.turbonet.base.b<>();
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public com.baidu.turbonet.base.b<b> dJK() {
            return this.mZe;
        }
    }

    private ApplicationStatus() {
    }

    public static void a(BaseChromiumApplication baseChromiumApplication) {
        baseChromiumApplication.a(new BaseChromiumApplication.b() { // from class: com.baidu.turbonet.base.ApplicationStatus.1
            @Override // com.baidu.turbonet.base.BaseChromiumApplication.b
            public void m(Activity activity, boolean z) {
                int au;
                if (z && activity != ApplicationStatus.mYY && (au = ApplicationStatus.au(activity)) != 6 && au != 5) {
                    Activity unused = ApplicationStatus.mYY = activity;
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
        if (mYY == null || i == 1 || i == 3 || i == 2) {
            mYY = activity;
        }
        int stateForApplication = getStateForApplication();
        if (i == 1) {
            if (!$assertionsDisabled && mZa.containsKey(activity)) {
                throw new AssertionError();
            }
            mZa.put(activity, new a());
        }
        synchronized (mYW) {
            mYX = null;
        }
        a aVar = mZa.get(activity);
        aVar.setStatus(i);
        Iterator<b> it = aVar.dJK().iterator();
        while (it.hasNext()) {
            it.next().l(activity, i);
        }
        Iterator<b> it2 = mZb.iterator();
        while (it2.hasNext()) {
            it2.next().l(activity, i);
        }
        int stateForApplication2 = getStateForApplication();
        if (stateForApplication2 != stateForApplication) {
            Iterator<c> it3 = mZc.iterator();
            while (it3.hasNext()) {
                it3.next().JY(stateForApplication2);
            }
        }
        if (i == 6) {
            mZa.remove(activity);
            if (activity == mYY) {
                mYY = null;
            }
        }
    }

    public static int au(Activity activity) {
        a aVar = mZa.get(activity);
        if (aVar != null) {
            return aVar.getStatus();
        }
        return 6;
    }

    @CalledByNative
    public static int getStateForApplication() {
        int intValue;
        synchronized (mYW) {
            if (mYX == null) {
                mYX = Integer.valueOf(dJH());
            }
            intValue = mYX.intValue();
        }
        return intValue;
    }

    public static void a(c cVar) {
        mZc.aM(cVar);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.turbonet.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.mYZ == null) {
                    c unused = ApplicationStatus.mYZ = new c() { // from class: com.baidu.turbonet.base.ApplicationStatus.3.1
                        @Override // com.baidu.turbonet.base.ApplicationStatus.c
                        public void JY(int i) {
                            ApplicationStatus.nativeOnApplicationStateChange(i);
                        }
                    };
                    ApplicationStatus.a(ApplicationStatus.mYZ);
                }
            }
        });
    }

    private static int dJH() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = false;
        for (a aVar : mZa.values()) {
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
