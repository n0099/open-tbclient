package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a ihn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.ihn = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.ihn.bTl()) {
            for (a.InterfaceC0347a interfaceC0347a : this.ihn.bTl()) {
                interfaceC0347a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.ihn.bTl()) {
            for (a.InterfaceC0347a interfaceC0347a : this.ihn.bTl()) {
                interfaceC0347a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.ihn.bTl()) {
            for (a.InterfaceC0347a interfaceC0347a : this.ihn.bTl()) {
                interfaceC0347a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.ihn.bTl()) {
            Iterator<a.InterfaceC0347a> it = this.ihn.bTl().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.ihn.bTl()) {
            Iterator<a.InterfaceC0347a> it = this.ihn.bTl().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.ihn.bTl()) {
            Iterator<a.InterfaceC0347a> it = this.ihn.bTl().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.ihn.bTl()) {
            for (a.InterfaceC0347a interfaceC0347a : this.ihn.bTl()) {
                interfaceC0347a.onActivityDestroyed(activity);
            }
        }
    }
}
