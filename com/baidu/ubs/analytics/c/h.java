package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a nFT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.nFT = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.nFT.dUe()) {
            for (a.InterfaceC0864a interfaceC0864a : this.nFT.dUe()) {
                interfaceC0864a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.nFT.dUe()) {
            for (a.InterfaceC0864a interfaceC0864a : this.nFT.dUe()) {
                interfaceC0864a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.nFT.dUe()) {
            for (a.InterfaceC0864a interfaceC0864a : this.nFT.dUe()) {
                interfaceC0864a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.nFT.dUe()) {
            Iterator<a.InterfaceC0864a> it = this.nFT.dUe().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.nFT.dUe()) {
            Iterator<a.InterfaceC0864a> it = this.nFT.dUe().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.nFT.dUe()) {
            Iterator<a.InterfaceC0864a> it = this.nFT.dUe().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.nFT.dUe()) {
            for (a.InterfaceC0864a interfaceC0864a : this.nFT.dUe()) {
                interfaceC0864a.onActivityDestroyed(activity);
            }
        }
    }
}
