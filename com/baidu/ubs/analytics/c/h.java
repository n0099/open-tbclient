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
        synchronized (this.oOx.ejC()) {
            for (a.InterfaceC0964a interfaceC0964a : this.oOx.ejC()) {
                interfaceC0964a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.oOx.ejC()) {
            for (a.InterfaceC0964a interfaceC0964a : this.oOx.ejC()) {
                interfaceC0964a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.oOx.ejC()) {
            for (a.InterfaceC0964a interfaceC0964a : this.oOx.ejC()) {
                interfaceC0964a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.oOx.ejC()) {
            Iterator<a.InterfaceC0964a> it = this.oOx.ejC().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.oOx.ejC()) {
            Iterator<a.InterfaceC0964a> it = this.oOx.ejC().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.oOx.ejC()) {
            Iterator<a.InterfaceC0964a> it = this.oOx.ejC().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.oOx.ejC()) {
            for (a.InterfaceC0964a interfaceC0964a : this.oOx.ejC()) {
                interfaceC0964a.onActivityDestroyed(activity);
            }
        }
    }
}
