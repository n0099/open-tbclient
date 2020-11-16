package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a ote;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.ote = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.ote.edD()) {
            for (a.InterfaceC0933a interfaceC0933a : this.ote.edD()) {
                interfaceC0933a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.ote.edD()) {
            for (a.InterfaceC0933a interfaceC0933a : this.ote.edD()) {
                interfaceC0933a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.ote.edD()) {
            for (a.InterfaceC0933a interfaceC0933a : this.ote.edD()) {
                interfaceC0933a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.ote.edD()) {
            Iterator<a.InterfaceC0933a> it = this.ote.edD().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.ote.edD()) {
            Iterator<a.InterfaceC0933a> it = this.ote.edD().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.ote.edD()) {
            Iterator<a.InterfaceC0933a> it = this.ote.edD().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.ote.edD()) {
            for (a.InterfaceC0933a interfaceC0933a : this.ote.edD()) {
                interfaceC0933a.onActivityDestroyed(activity);
            }
        }
    }
}
