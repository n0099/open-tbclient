package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a oUB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.oUB = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.oUB.eik()) {
            for (a.InterfaceC0953a interfaceC0953a : this.oUB.eik()) {
                interfaceC0953a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.oUB.eik()) {
            for (a.InterfaceC0953a interfaceC0953a : this.oUB.eik()) {
                interfaceC0953a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.oUB.eik()) {
            for (a.InterfaceC0953a interfaceC0953a : this.oUB.eik()) {
                interfaceC0953a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.oUB.eik()) {
            Iterator<a.InterfaceC0953a> it = this.oUB.eik().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.oUB.eik()) {
            Iterator<a.InterfaceC0953a> it = this.oUB.eik().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.oUB.eik()) {
            Iterator<a.InterfaceC0953a> it = this.oUB.eik().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.oUB.eik()) {
            for (a.InterfaceC0953a interfaceC0953a : this.oUB.eik()) {
                interfaceC0953a.onActivityDestroyed(activity);
            }
        }
    }
}
