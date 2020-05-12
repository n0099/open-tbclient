package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a lOH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.lOH = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.lOH.dkZ()) {
            for (a.InterfaceC0712a interfaceC0712a : this.lOH.dkZ()) {
                interfaceC0712a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.lOH.dkZ()) {
            for (a.InterfaceC0712a interfaceC0712a : this.lOH.dkZ()) {
                interfaceC0712a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.lOH.dkZ()) {
            for (a.InterfaceC0712a interfaceC0712a : this.lOH.dkZ()) {
                interfaceC0712a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.lOH.dkZ()) {
            Iterator<a.InterfaceC0712a> it = this.lOH.dkZ().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.lOH.dkZ()) {
            Iterator<a.InterfaceC0712a> it = this.lOH.dkZ().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.lOH.dkZ()) {
            Iterator<a.InterfaceC0712a> it = this.lOH.dkZ().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lOH.dkZ()) {
            for (a.InterfaceC0712a interfaceC0712a : this.lOH.dkZ()) {
                interfaceC0712a.onActivityDestroyed(activity);
            }
        }
    }
}
