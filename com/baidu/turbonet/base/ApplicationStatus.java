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
/* loaded from: classes19.dex */
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static Object mFX;
    private static Integer mFY;
    private static Activity mFZ;
    private static c mGa;
    private static final Map<Activity, a> mGb;
    private static final com.baidu.turbonet.base.b<b> mGc;
    private static final com.baidu.turbonet.base.b<c> mGd;

    /* loaded from: classes19.dex */
    public interface b {
        void l(Activity activity, int i);
    }

    /* loaded from: classes19.dex */
    public interface c {
        void Hy(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnApplicationStateChange(int i);

    static {
        $assertionsDisabled = !ApplicationStatus.class.desiredAssertionStatus();
        mFX = new Object();
        mGb = new ConcurrentHashMap();
        mGc = new com.baidu.turbonet.base.b<>();
        mGd = new com.baidu.turbonet.base.b<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public static class a {
        private com.baidu.turbonet.base.b<b> mGf;
        private int mStatus;

        private a() {
            this.mStatus = 6;
            this.mGf = new com.baidu.turbonet.base.b<>();
        }

        public int getStatus() {
            return this.mStatus;
        }

        public void setStatus(int i) {
            this.mStatus = i;
        }

        public com.baidu.turbonet.base.b<b> dxX() {
            return this.mGf;
        }
    }

    private ApplicationStatus() {
    }

    public static void a(BaseChromiumApplication baseChromiumApplication) {
        baseChromiumApplication.a(new BaseChromiumApplication.b() { // from class: com.baidu.turbonet.base.ApplicationStatus.1
            @Override // com.baidu.turbonet.base.BaseChromiumApplication.b
            public void l(Activity activity, boolean z) {
                int at;
                if (z && activity != ApplicationStatus.mFZ && (at = ApplicationStatus.at(activity)) != 6 && at != 5) {
                    Activity unused = ApplicationStatus.mFZ = activity;
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
        if (mFZ == null || i == 1 || i == 3 || i == 2) {
            mFZ = activity;
        }
        int stateForApplication = getStateForApplication();
        if (i == 1) {
            if (!$assertionsDisabled && mGb.containsKey(activity)) {
                throw new AssertionError();
            }
            mGb.put(activity, new a());
        }
        synchronized (mFX) {
            mFY = null;
        }
        a aVar = mGb.get(activity);
        aVar.setStatus(i);
        Iterator<b> it = aVar.dxX().iterator();
        while (it.hasNext()) {
            it.next().l(activity, i);
        }
        Iterator<b> it2 = mGc.iterator();
        while (it2.hasNext()) {
            it2.next().l(activity, i);
        }
        int stateForApplication2 = getStateForApplication();
        if (stateForApplication2 != stateForApplication) {
            Iterator<c> it3 = mGd.iterator();
            while (it3.hasNext()) {
                it3.next().Hy(stateForApplication2);
            }
        }
        if (i == 6) {
            mGb.remove(activity);
            if (activity == mFZ) {
                mFZ = null;
            }
        }
    }

    public static int at(Activity activity) {
        a aVar = mGb.get(activity);
        if (aVar != null) {
            return aVar.getStatus();
        }
        return 6;
    }

    @CalledByNative
    public static int getStateForApplication() {
        int intValue;
        synchronized (mFX) {
            if (mFY == null) {
                mFY = Integer.valueOf(dxU());
            }
            intValue = mFY.intValue();
        }
        return intValue;
    }

    public static void a(c cVar) {
        mGd.aK(cVar);
    }

    @CalledByNative
    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.baidu.turbonet.base.ApplicationStatus.3
            @Override // java.lang.Runnable
            public void run() {
                if (ApplicationStatus.mGa == null) {
                    c unused = ApplicationStatus.mGa = new c() { // from class: com.baidu.turbonet.base.ApplicationStatus.3.1
                        @Override // com.baidu.turbonet.base.ApplicationStatus.c
                        public void Hy(int i) {
                            ApplicationStatus.nativeOnApplicationStateChange(i);
                        }
                    };
                    ApplicationStatus.a(ApplicationStatus.mGa);
                }
            }
        });
    }

    private static int dxU() {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = false;
        for (a aVar : mGb.values()) {
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
