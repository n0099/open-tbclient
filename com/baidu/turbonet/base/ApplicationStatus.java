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
/* loaded from: classes5.dex */
public class ApplicationStatus {

    /* renamed from: b  reason: collision with root package name */
    public static Integer f22315b;

    /* renamed from: c  reason: collision with root package name */
    public static Activity f22316c;

    /* renamed from: d  reason: collision with root package name */
    public static f f22317d;

    /* renamed from: a  reason: collision with root package name */
    public static Object f22314a = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static final Map<Activity, d> f22318e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    public static final d.b.j0.a.b<e> f22319f = new d.b.j0.a.b<>();

    /* renamed from: g  reason: collision with root package name */
    public static final d.b.j0.a.b<f> f22320g = new d.b.j0.a.b<>();

    /* loaded from: classes5.dex */
    public static class a implements BaseChromiumApplication.c {
        @Override // com.baidu.turbonet.base.BaseChromiumApplication.c
        public void a(Activity activity, boolean z) {
            int h2;
            if (!z || activity == ApplicationStatus.f22316c || (h2 = ApplicationStatus.h(activity)) == 6 || h2 == 5) {
                return;
            }
            Activity unused = ApplicationStatus.f22316c = activity;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {
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
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {

        /* loaded from: classes5.dex */
        public class a implements f {
            public a(c cVar) {
            }

            @Override // com.baidu.turbonet.base.ApplicationStatus.f
            public void a(int i) {
                ApplicationStatus.nativeOnApplicationStateChange(i);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ApplicationStatus.f22317d != null) {
                return;
            }
            f unused = ApplicationStatus.f22317d = new a(this);
            ApplicationStatus.k(ApplicationStatus.f22317d);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(Activity activity, int i);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(int i);
    }

    public static int g() {
        boolean z = false;
        boolean z2 = false;
        for (d dVar : f22318e.values()) {
            int b2 = dVar.b();
            if (b2 != 4 && b2 != 5 && b2 != 6) {
                return 1;
            }
            if (b2 == 4) {
                z = true;
            } else if (b2 == 5) {
                z2 = true;
            }
        }
        if (z) {
            return 2;
        }
        return z2 ? 3 : 4;
    }

    @CalledByNative
    public static int getStateForApplication() {
        int intValue;
        synchronized (f22314a) {
            if (f22315b == null) {
                f22315b = Integer.valueOf(g());
            }
            intValue = f22315b.intValue();
        }
        return intValue;
    }

    public static int h(Activity activity) {
        d dVar = f22318e.get(activity);
        if (dVar != null) {
            return dVar.b();
        }
        return 6;
    }

    public static void i(BaseChromiumApplication baseChromiumApplication) {
        baseChromiumApplication.registerWindowFocusChangedListener(new a());
        baseChromiumApplication.registerActivityLifecycleCallbacks(new b());
    }

    public static void j(Activity activity, int i) {
        if (activity != null) {
            if (f22316c == null || i == 1 || i == 3 || i == 2) {
                f22316c = activity;
            }
            int stateForApplication = getStateForApplication();
            if (i == 1) {
                f22318e.put(activity, new d(null));
            }
            synchronized (f22314a) {
                f22315b = null;
            }
            d dVar = f22318e.get(activity);
            dVar.c(i);
            Iterator<e> it = dVar.a().iterator();
            while (it.hasNext()) {
                it.next().a(activity, i);
            }
            Iterator<e> it2 = f22319f.iterator();
            while (it2.hasNext()) {
                it2.next().a(activity, i);
            }
            int stateForApplication2 = getStateForApplication();
            if (stateForApplication2 != stateForApplication) {
                Iterator<f> it3 = f22320g.iterator();
                while (it3.hasNext()) {
                    it3.next().a(stateForApplication2);
                }
            }
            if (i == 6) {
                f22318e.remove(activity);
                if (activity == f22316c) {
                    f22316c = null;
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("null activity is not supported");
    }

    public static void k(f fVar) {
        f22320g.e(fVar);
    }

    public static native void nativeOnApplicationStateChange(int i);

    @CalledByNative
    public static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.c(new c());
    }

    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f22321a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.j0.a.b<e> f22322b;

        public d() {
            this.f22321a = 6;
            this.f22322b = new d.b.j0.a.b<>();
        }

        public d.b.j0.a.b<e> a() {
            return this.f22322b;
        }

        public int b() {
            return this.f22321a;
        }

        public void c(int i) {
            this.f22321a = i;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
