package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a kRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.kRW = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.kRW.cUY()) {
            for (a.InterfaceC0629a interfaceC0629a : this.kRW.cUY()) {
                interfaceC0629a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.kRW.cUY()) {
            for (a.InterfaceC0629a interfaceC0629a : this.kRW.cUY()) {
                interfaceC0629a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.kRW.cUY()) {
            for (a.InterfaceC0629a interfaceC0629a : this.kRW.cUY()) {
                interfaceC0629a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.kRW.cUY()) {
            Iterator<a.InterfaceC0629a> it = this.kRW.cUY().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.kRW.cUY()) {
            Iterator<a.InterfaceC0629a> it = this.kRW.cUY().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.kRW.cUY()) {
            Iterator<a.InterfaceC0629a> it = this.kRW.cUY().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.kRW.cUY()) {
            for (a.InterfaceC0629a interfaceC0629a : this.kRW.cUY()) {
                interfaceC0629a.onActivityDestroyed(activity);
            }
        }
    }
}
