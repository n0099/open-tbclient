package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a oiv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.oiv = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.oiv.dZW()) {
            for (a.InterfaceC0914a interfaceC0914a : this.oiv.dZW()) {
                interfaceC0914a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.oiv.dZW()) {
            for (a.InterfaceC0914a interfaceC0914a : this.oiv.dZW()) {
                interfaceC0914a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.oiv.dZW()) {
            for (a.InterfaceC0914a interfaceC0914a : this.oiv.dZW()) {
                interfaceC0914a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.oiv.dZW()) {
            Iterator<a.InterfaceC0914a> it = this.oiv.dZW().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.oiv.dZW()) {
            Iterator<a.InterfaceC0914a> it = this.oiv.dZW().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.oiv.dZW()) {
            Iterator<a.InterfaceC0914a> it = this.oiv.dZW().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.oiv.dZW()) {
            for (a.InterfaceC0914a interfaceC0914a : this.oiv.dZW()) {
                interfaceC0914a.onActivityDestroyed(activity);
            }
        }
    }
}
