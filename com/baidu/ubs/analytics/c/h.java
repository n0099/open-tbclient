package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a ngf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.ngf = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.ngf.dMm()) {
            for (a.InterfaceC0849a interfaceC0849a : this.ngf.dMm()) {
                interfaceC0849a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.ngf.dMm()) {
            for (a.InterfaceC0849a interfaceC0849a : this.ngf.dMm()) {
                interfaceC0849a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.ngf.dMm()) {
            for (a.InterfaceC0849a interfaceC0849a : this.ngf.dMm()) {
                interfaceC0849a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.ngf.dMm()) {
            Iterator<a.InterfaceC0849a> it = this.ngf.dMm().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.ngf.dMm()) {
            Iterator<a.InterfaceC0849a> it = this.ngf.dMm().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.ngf.dMm()) {
            Iterator<a.InterfaceC0849a> it = this.ngf.dMm().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.ngf.dMm()) {
            for (a.InterfaceC0849a interfaceC0849a : this.ngf.dMm()) {
                interfaceC0849a.onActivityDestroyed(activity);
            }
        }
    }
}
