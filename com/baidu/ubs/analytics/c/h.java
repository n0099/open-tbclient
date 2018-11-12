package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a hVI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.hVI = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.hVI.bPH()) {
            for (a.InterfaceC0334a interfaceC0334a : this.hVI.bPH()) {
                interfaceC0334a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.hVI.bPH()) {
            for (a.InterfaceC0334a interfaceC0334a : this.hVI.bPH()) {
                interfaceC0334a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.hVI.bPH()) {
            for (a.InterfaceC0334a interfaceC0334a : this.hVI.bPH()) {
                interfaceC0334a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.hVI.bPH()) {
            Iterator<a.InterfaceC0334a> it = this.hVI.bPH().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.hVI.bPH()) {
            Iterator<a.InterfaceC0334a> it = this.hVI.bPH().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.hVI.bPH()) {
            Iterator<a.InterfaceC0334a> it = this.hVI.bPH().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.hVI.bPH()) {
            for (a.InterfaceC0334a interfaceC0334a : this.hVI.bPH()) {
                interfaceC0334a.onActivityDestroyed(activity);
            }
        }
    }
}
