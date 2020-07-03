package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a mFa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.mFa = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.mFa.dxi()) {
            for (a.InterfaceC0785a interfaceC0785a : this.mFa.dxi()) {
                interfaceC0785a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.mFa.dxi()) {
            for (a.InterfaceC0785a interfaceC0785a : this.mFa.dxi()) {
                interfaceC0785a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.mFa.dxi()) {
            for (a.InterfaceC0785a interfaceC0785a : this.mFa.dxi()) {
                interfaceC0785a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.mFa.dxi()) {
            Iterator<a.InterfaceC0785a> it = this.mFa.dxi().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.mFa.dxi()) {
            Iterator<a.InterfaceC0785a> it = this.mFa.dxi().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.mFa.dxi()) {
            Iterator<a.InterfaceC0785a> it = this.mFa.dxi().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.mFa.dxi()) {
            for (a.InterfaceC0785a interfaceC0785a : this.mFa.dxi()) {
                interfaceC0785a.onActivityDestroyed(activity);
            }
        }
    }
}
