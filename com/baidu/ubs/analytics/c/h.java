package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a kWw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.kWw = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.kWw.cXu()) {
            for (a.InterfaceC0642a interfaceC0642a : this.kWw.cXu()) {
                interfaceC0642a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.kWw.cXu()) {
            for (a.InterfaceC0642a interfaceC0642a : this.kWw.cXu()) {
                interfaceC0642a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.kWw.cXu()) {
            for (a.InterfaceC0642a interfaceC0642a : this.kWw.cXu()) {
                interfaceC0642a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.kWw.cXu()) {
            Iterator<a.InterfaceC0642a> it = this.kWw.cXu().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.kWw.cXu()) {
            Iterator<a.InterfaceC0642a> it = this.kWw.cXu().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.kWw.cXu()) {
            Iterator<a.InterfaceC0642a> it = this.kWw.cXu().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.kWw.cXu()) {
            for (a.InterfaceC0642a interfaceC0642a : this.kWw.cXu()) {
                interfaceC0642a.onActivityDestroyed(activity);
            }
        }
    }
}
