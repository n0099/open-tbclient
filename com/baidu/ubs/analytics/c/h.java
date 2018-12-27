package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a igf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.igf = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.igf.bSD()) {
            for (a.InterfaceC0348a interfaceC0348a : this.igf.bSD()) {
                interfaceC0348a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.igf.bSD()) {
            for (a.InterfaceC0348a interfaceC0348a : this.igf.bSD()) {
                interfaceC0348a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.igf.bSD()) {
            for (a.InterfaceC0348a interfaceC0348a : this.igf.bSD()) {
                interfaceC0348a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.igf.bSD()) {
            Iterator<a.InterfaceC0348a> it = this.igf.bSD().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.igf.bSD()) {
            Iterator<a.InterfaceC0348a> it = this.igf.bSD().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.igf.bSD()) {
            Iterator<a.InterfaceC0348a> it = this.igf.bSD().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.igf.bSD()) {
            for (a.InterfaceC0348a interfaceC0348a : this.igf.bSD()) {
                interfaceC0348a.onActivityDestroyed(activity);
            }
        }
    }
}
