package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a jPJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.jPJ = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.jPJ.cAp()) {
            for (a.InterfaceC0440a interfaceC0440a : this.jPJ.cAp()) {
                interfaceC0440a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.jPJ.cAp()) {
            for (a.InterfaceC0440a interfaceC0440a : this.jPJ.cAp()) {
                interfaceC0440a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.jPJ.cAp()) {
            for (a.InterfaceC0440a interfaceC0440a : this.jPJ.cAp()) {
                interfaceC0440a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.jPJ.cAp()) {
            Iterator<a.InterfaceC0440a> it = this.jPJ.cAp().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.jPJ.cAp()) {
            Iterator<a.InterfaceC0440a> it = this.jPJ.cAp().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.jPJ.cAp()) {
            Iterator<a.InterfaceC0440a> it = this.jPJ.cAp().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.jPJ.cAp()) {
            for (a.InterfaceC0440a interfaceC0440a : this.jPJ.cAp()) {
                interfaceC0440a.onActivityDestroyed(activity);
            }
        }
    }
}
