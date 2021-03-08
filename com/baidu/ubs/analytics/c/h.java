package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a oWG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.oWG = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.oWG.eit()) {
            for (a.InterfaceC0959a interfaceC0959a : this.oWG.eit()) {
                interfaceC0959a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.oWG.eit()) {
            for (a.InterfaceC0959a interfaceC0959a : this.oWG.eit()) {
                interfaceC0959a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.oWG.eit()) {
            for (a.InterfaceC0959a interfaceC0959a : this.oWG.eit()) {
                interfaceC0959a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.oWG.eit()) {
            Iterator<a.InterfaceC0959a> it = this.oWG.eit().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.oWG.eit()) {
            Iterator<a.InterfaceC0959a> it = this.oWG.eit().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.oWG.eit()) {
            Iterator<a.InterfaceC0959a> it = this.oWG.eit().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.oWG.eit()) {
            for (a.InterfaceC0959a interfaceC0959a : this.oWG.eit()) {
                interfaceC0959a.onActivityDestroyed(activity);
            }
        }
    }
}
