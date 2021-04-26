package com.baidu.turbonet.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class BaseChromiumApplication extends Application {
    public static final String TAG = "cr.base";
    public static final String TOOLBAR_CALLBACK_INTERNAL_WRAPPER_CLASS = "androidx.appcompat.internal.app.ToolbarActionBar$ToolbarCallbackWrapper";
    public static final String TOOLBAR_CALLBACK_WRAPPER_CLASS = "androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper";
    public final boolean mShouldInitializeApplicationStatusTracking;
    public d.a.k0.a.b<c> mWindowFocusListeners;

    /* loaded from: classes5.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            activity.getWindow().setCallback((Window.Callback) Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new b(activity, activity.getWindow().getCallback())));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements InvocationHandler {

        /* renamed from: e  reason: collision with root package name */
        public final Window.Callback f23024e;

        /* renamed from: f  reason: collision with root package name */
        public final Activity f23025f;

        public b(Activity activity, Window.Callback callback) {
            this.f23024e = callback;
            this.f23025f = activity;
        }

        public void a(boolean z) {
            this.f23024e.onWindowFocusChanged(z);
            Iterator it = BaseChromiumApplication.this.mWindowFocusListeners.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(this.f23025f, z);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getName().equals("onWindowFocusChanged") && objArr.length == 1 && (objArr[0] instanceof Boolean)) {
                a(((Boolean) objArr[0]).booleanValue());
                return null;
            }
            try {
                return method.invoke(this.f23024e, objArr);
            } catch (InvocationTargetException e2) {
                if (e2.getCause() instanceof AbstractMethodError) {
                    throw e2.getCause();
                }
                throw e2;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(Activity activity, boolean z);
    }

    public BaseChromiumApplication() {
        this(true);
    }

    public static void initCommandLine(Context context) {
        ((BaseChromiumApplication) context.getApplicationContext()).initCommandLine();
    }

    private void startTrackingApplicationStatus() {
        ApplicationStatus.i(this);
        registerActivityLifecycleCallbacks(new a());
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        d.a.k0.a.c.a.b(this);
    }

    public void initCommandLine() {
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        if (this.mShouldInitializeApplicationStatusTracking) {
            startTrackingApplicationStatus();
        }
    }

    public void registerWindowFocusChangedListener(c cVar) {
        this.mWindowFocusListeners.e(cVar);
    }

    public void unregisterWindowFocusChangedListener(c cVar) {
        this.mWindowFocusListeners.k(cVar);
    }

    public BaseChromiumApplication(boolean z) {
        this.mWindowFocusListeners = new d.a.k0.a.b<>();
        this.mShouldInitializeApplicationStatusTracking = z;
    }
}
