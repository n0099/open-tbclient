package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a hLf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.hLf = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.hLf.bLT()) {
            for (a.InterfaceC0269a interfaceC0269a : this.hLf.bLT()) {
                interfaceC0269a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.hLf.bLT()) {
            for (a.InterfaceC0269a interfaceC0269a : this.hLf.bLT()) {
                interfaceC0269a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.hLf.bLT()) {
            for (a.InterfaceC0269a interfaceC0269a : this.hLf.bLT()) {
                interfaceC0269a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.hLf.bLT()) {
            Iterator<a.InterfaceC0269a> it = this.hLf.bLT().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.hLf.bLT()) {
            Iterator<a.InterfaceC0269a> it = this.hLf.bLT().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.hLf.bLT()) {
            Iterator<a.InterfaceC0269a> it = this.hLf.bLT().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.hLf.bLT()) {
            for (a.InterfaceC0269a interfaceC0269a : this.hLf.bLT()) {
                interfaceC0269a.onActivityDestroyed(activity);
            }
        }
    }
}
