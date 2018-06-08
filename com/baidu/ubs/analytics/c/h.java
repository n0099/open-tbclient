package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a hxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.hxV = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.hxV.bJT()) {
            for (a.InterfaceC0261a interfaceC0261a : this.hxV.bJT()) {
                interfaceC0261a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.hxV.bJT()) {
            for (a.InterfaceC0261a interfaceC0261a : this.hxV.bJT()) {
                interfaceC0261a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.hxV.bJT()) {
            for (a.InterfaceC0261a interfaceC0261a : this.hxV.bJT()) {
                interfaceC0261a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.hxV.bJT()) {
            Iterator<a.InterfaceC0261a> it = this.hxV.bJT().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.hxV.bJT()) {
            Iterator<a.InterfaceC0261a> it = this.hxV.bJT().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.hxV.bJT()) {
            Iterator<a.InterfaceC0261a> it = this.hxV.bJT().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.hxV.bJT()) {
            for (a.InterfaceC0261a interfaceC0261a : this.hxV.bJT()) {
                interfaceC0261a.onActivityDestroyed(activity);
            }
        }
    }
}
