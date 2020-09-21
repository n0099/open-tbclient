package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a nqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.nqz = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.nqz.dQt()) {
            for (a.InterfaceC0846a interfaceC0846a : this.nqz.dQt()) {
                interfaceC0846a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.nqz.dQt()) {
            for (a.InterfaceC0846a interfaceC0846a : this.nqz.dQt()) {
                interfaceC0846a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.nqz.dQt()) {
            for (a.InterfaceC0846a interfaceC0846a : this.nqz.dQt()) {
                interfaceC0846a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.nqz.dQt()) {
            Iterator<a.InterfaceC0846a> it = this.nqz.dQt().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.nqz.dQt()) {
            Iterator<a.InterfaceC0846a> it = this.nqz.dQt().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.nqz.dQt()) {
            Iterator<a.InterfaceC0846a> it = this.nqz.dQt().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.nqz.dQt()) {
            for (a.InterfaceC0846a interfaceC0846a : this.nqz.dQt()) {
                interfaceC0846a.onActivityDestroyed(activity);
            }
        }
    }
}
