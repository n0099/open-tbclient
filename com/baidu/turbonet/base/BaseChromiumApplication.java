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
/* loaded from: classes.dex */
public class BaseChromiumApplication extends Application {
    private final boolean lHC;
    private com.baidu.turbonet.base.b<b> lHD;

    /* loaded from: classes.dex */
    public interface b {
        void k(Activity activity, boolean z);
    }

    public BaseChromiumApplication() {
        this(true);
    }

    protected BaseChromiumApplication(boolean z) {
        this.lHD = new com.baidu.turbonet.base.b<>();
        this.lHC = z;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        com.baidu.turbonet.base.a.a.install(this);
    }

    /* loaded from: classes.dex */
    private class a implements InvocationHandler {
        private final Window.Callback lHF;
        private final Activity mActivity;

        public a(Activity activity, Window.Callback callback) {
            this.lHF = callback;
            this.mActivity = activity;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getName().equals("onWindowFocusChanged") && objArr.length == 1 && (objArr[0] instanceof Boolean)) {
                onWindowFocusChanged(((Boolean) objArr[0]).booleanValue());
                return null;
            }
            try {
                return method.invoke(this.lHF, objArr);
            } catch (InvocationTargetException e) {
                if (e.getCause() instanceof AbstractMethodError) {
                    throw e.getCause();
                }
                throw e;
            }
        }

        public void onWindowFocusChanged(boolean z) {
            this.lHF.onWindowFocusChanged(z);
            Iterator it = BaseChromiumApplication.this.lHD.iterator();
            while (it.hasNext()) {
                ((b) it.next()).k(this.mActivity, z);
            }
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        if (this.lHC) {
            diy();
        }
    }

    public void a(b bVar) {
        this.lHD.aF(bVar);
    }

    private void diy() {
        ApplicationStatus.a(this);
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.baidu.turbonet.base.BaseChromiumApplication.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                activity.getWindow().setCallback((Window.Callback) Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new a(activity, activity.getWindow().getCallback())));
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
        });
    }
}
