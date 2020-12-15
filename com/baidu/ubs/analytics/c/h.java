package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a oIp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.oIp = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.oIp.ejs()) {
            for (a.InterfaceC0950a interfaceC0950a : this.oIp.ejs()) {
                interfaceC0950a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.oIp.ejs()) {
            for (a.InterfaceC0950a interfaceC0950a : this.oIp.ejs()) {
                interfaceC0950a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.oIp.ejs()) {
            for (a.InterfaceC0950a interfaceC0950a : this.oIp.ejs()) {
                interfaceC0950a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.oIp.ejs()) {
            Iterator<a.InterfaceC0950a> it = this.oIp.ejs().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.oIp.ejs()) {
            Iterator<a.InterfaceC0950a> it = this.oIp.ejs().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.oIp.ejs()) {
            Iterator<a.InterfaceC0950a> it = this.oIp.ejs().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.oIp.ejs()) {
            for (a.InterfaceC0950a interfaceC0950a : this.oIp.ejs()) {
                interfaceC0950a.onActivityDestroyed(activity);
            }
        }
    }
}
