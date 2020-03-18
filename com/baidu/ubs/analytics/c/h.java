package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a kXZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.kXZ = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.kXZ.cXS()) {
            for (a.InterfaceC0643a interfaceC0643a : this.kXZ.cXS()) {
                interfaceC0643a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.kXZ.cXS()) {
            for (a.InterfaceC0643a interfaceC0643a : this.kXZ.cXS()) {
                interfaceC0643a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.kXZ.cXS()) {
            for (a.InterfaceC0643a interfaceC0643a : this.kXZ.cXS()) {
                interfaceC0643a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.kXZ.cXS()) {
            Iterator<a.InterfaceC0643a> it = this.kXZ.cXS().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.kXZ.cXS()) {
            Iterator<a.InterfaceC0643a> it = this.kXZ.cXS().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.kXZ.cXS()) {
            Iterator<a.InterfaceC0643a> it = this.kXZ.cXS().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.kXZ.cXS()) {
            for (a.InterfaceC0643a interfaceC0643a : this.kXZ.cXS()) {
                interfaceC0643a.onActivityDestroyed(activity);
            }
        }
    }
}
