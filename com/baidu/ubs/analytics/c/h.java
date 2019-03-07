package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a jwR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.jwR = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.jwR.csh()) {
            for (a.InterfaceC0325a interfaceC0325a : this.jwR.csh()) {
                interfaceC0325a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.jwR.csh()) {
            for (a.InterfaceC0325a interfaceC0325a : this.jwR.csh()) {
                interfaceC0325a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.jwR.csh()) {
            for (a.InterfaceC0325a interfaceC0325a : this.jwR.csh()) {
                interfaceC0325a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.jwR.csh()) {
            Iterator<a.InterfaceC0325a> it = this.jwR.csh().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.jwR.csh()) {
            Iterator<a.InterfaceC0325a> it = this.jwR.csh().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.jwR.csh()) {
            Iterator<a.InterfaceC0325a> it = this.jwR.csh().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.jwR.csh()) {
            for (a.InterfaceC0325a interfaceC0325a : this.jwR.csh()) {
                interfaceC0325a.onActivityDestroyed(activity);
            }
        }
    }
}
