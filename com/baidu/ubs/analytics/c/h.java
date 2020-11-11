package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a orB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.orB = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.orB.edE()) {
            for (a.InterfaceC0930a interfaceC0930a : this.orB.edE()) {
                interfaceC0930a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.orB.edE()) {
            for (a.InterfaceC0930a interfaceC0930a : this.orB.edE()) {
                interfaceC0930a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.orB.edE()) {
            for (a.InterfaceC0930a interfaceC0930a : this.orB.edE()) {
                interfaceC0930a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.orB.edE()) {
            Iterator<a.InterfaceC0930a> it = this.orB.edE().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.orB.edE()) {
            Iterator<a.InterfaceC0930a> it = this.orB.edE().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.orB.edE()) {
            Iterator<a.InterfaceC0930a> it = this.orB.edE().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.orB.edE()) {
            for (a.InterfaceC0930a interfaceC0930a : this.orB.edE()) {
                interfaceC0930a.onActivityDestroyed(activity);
            }
        }
    }
}
