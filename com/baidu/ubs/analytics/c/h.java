package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a oJS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.oJS = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.oJS.efK()) {
            for (a.InterfaceC0947a interfaceC0947a : this.oJS.efK()) {
                interfaceC0947a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.oJS.efK()) {
            for (a.InterfaceC0947a interfaceC0947a : this.oJS.efK()) {
                interfaceC0947a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.oJS.efK()) {
            for (a.InterfaceC0947a interfaceC0947a : this.oJS.efK()) {
                interfaceC0947a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.oJS.efK()) {
            Iterator<a.InterfaceC0947a> it = this.oJS.efK().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.oJS.efK()) {
            Iterator<a.InterfaceC0947a> it = this.oJS.efK().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.oJS.efK()) {
            Iterator<a.InterfaceC0947a> it = this.oJS.efK().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.oJS.efK()) {
            for (a.InterfaceC0947a interfaceC0947a : this.oJS.efK()) {
                interfaceC0947a.onActivityDestroyed(activity);
            }
        }
    }
}
