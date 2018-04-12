package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a hla;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.hla = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.hla.bER()) {
            for (a.InterfaceC0244a interfaceC0244a : this.hla.bER()) {
                interfaceC0244a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.hla.bER()) {
            for (a.InterfaceC0244a interfaceC0244a : this.hla.bER()) {
                interfaceC0244a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.hla.bER()) {
            for (a.InterfaceC0244a interfaceC0244a : this.hla.bER()) {
                interfaceC0244a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.hla.bER()) {
            Iterator<a.InterfaceC0244a> it = this.hla.bER().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.hla.bER()) {
            Iterator<a.InterfaceC0244a> it = this.hla.bER().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.hla.bER()) {
            Iterator<a.InterfaceC0244a> it = this.hla.bER().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.hla.bER()) {
            for (a.InterfaceC0244a interfaceC0244a : this.hla.bER()) {
                interfaceC0244a.onActivityDestroyed(activity);
            }
        }
    }
}
