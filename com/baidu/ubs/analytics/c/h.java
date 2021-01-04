package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a oOx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.oOx = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.oOx.ejB()) {
            for (a.InterfaceC0926a interfaceC0926a : this.oOx.ejB()) {
                interfaceC0926a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.oOx.ejB()) {
            for (a.InterfaceC0926a interfaceC0926a : this.oOx.ejB()) {
                interfaceC0926a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.oOx.ejB()) {
            for (a.InterfaceC0926a interfaceC0926a : this.oOx.ejB()) {
                interfaceC0926a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.oOx.ejB()) {
            Iterator<a.InterfaceC0926a> it = this.oOx.ejB().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.oOx.ejB()) {
            Iterator<a.InterfaceC0926a> it = this.oOx.ejB().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.oOx.ejB()) {
            Iterator<a.InterfaceC0926a> it = this.oOx.ejB().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.oOx.ejB()) {
            for (a.InterfaceC0926a interfaceC0926a : this.oOx.ejB()) {
                interfaceC0926a.onActivityDestroyed(activity);
            }
        }
    }
}
