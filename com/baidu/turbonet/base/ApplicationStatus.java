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
    public static Integer f22292b;

    /* renamed from: c  reason: collision with root package name */
    public static Activity f22293c;

    /* renamed from: d  reason: collision with root package name */
    public static f f22294d;

    /* renamed from: a  reason: collision with root package name */
    public static Object f22291a = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static final Map<Activity, d> f22295e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    public static final d.a.o0.a.b<e> f22296f = new d.a.o0.a.b<>();

    /* renamed from: g  reason: collision with root package name */
    public static final d.a.o0.a.b<f> f22297g = new d.a.o0.a.b<>();

    /* loaded from: classes5.dex */
    public static class a implements BaseChromiumApplication.c {
        @Override // com.baidu.turbonet.base.BaseChromiumApplication.c
        public void a(Activity activity, boolean z) {
            int h2;
            if (!z || activity == ApplicationStatus.f22293c || (h2 = ApplicationStatus.h(activity)) == 6 || h2 == 5) {
                return;
            }
            Activity unused = ApplicationStatus.f22293c = activity;
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
            public void a(int i2) {
                ApplicationStatus.nativeOnApplicationStateChange(i2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ApplicationStatus.f22294d != null) {
                return;
            }
            f unused = ApplicationStatus.f22294d = new a(this);
            ApplicationStatus.k(ApplicationStatus.f22294d);
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(Activity activity, int i2);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void a(int i2);
    }

    public static int g() {
        boolean z = false;
        boolean z2 = false;
        for (d dVar : f22295e.values()) {
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
        synchronized (f22291a) {
            if (f22292b == null) {
                f22292b = Integer.valueOf(g());
            }
            intValue = f22292b.intValue();
        }
        return intValue;
    }

    public static int h(Activity activity) {
        d dVar = f22295e.get(activity);
        if (dVar != null) {
            return dVar.b();
        }
        return 6;
    }

    public static void i(BaseChromiumApplication baseChromiumApplication) {
        baseChromiumApplication.registerWindowFocusChangedListener(new a());
        baseChromiumApplication.registerActivityLifecycleCallbacks(new b());
    }

    public static void j(Activity activity, int i2) {
        if (activity != null) {
            if (f22293c == null || i2 == 1 || i2 == 3 || i2 == 2) {
                f22293c = activity;
            }
            int stateForApplication = getStateForApplication();
            if (i2 == 1) {
                f22295e.put(activity, new d(null));
            }
            synchronized (f22291a) {
                f22292b = null;
            }
            d dVar = f22295e.get(activity);
            dVar.c(i2);
            Iterator<e> it = dVar.a().iterator();
            while (it.hasNext()) {
                it.next().a(activity, i2);
            }
            Iterator<e> it2 = f22296f.iterator();
            while (it2.hasNext()) {
                it2.next().a(activity, i2);
            }
            int stateForApplication2 = getStateForApplication();
            if (stateForApplication2 != stateForApplication) {
                Iterator<f> it3 = f22297g.iterator();
                while (it3.hasNext()) {
                    it3.next().a(stateForApplication2);
                }
            }
            if (i2 == 6) {
                f22295e.remove(activity);
                if (activity == f22293c) {
                    f22293c = null;
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("null activity is not supported");
    }

    public static void k(f fVar) {
        f22297g.e(fVar);
    }

    public static native void nativeOnApplicationStateChange(int i2);

    @CalledByNative
    public static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.c(new c());
    }

    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f22298a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.o0.a.b<e> f22299b;

        public d() {
            this.f22298a = 6;
            this.f22299b = new d.a.o0.a.b<>();
        }

        public d.a.o0.a.b<e> a() {
            return this.f22299b;
        }

        public int b() {
            return this.f22298a;
        }

        public void c(int i2) {
            this.f22298a = i2;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
