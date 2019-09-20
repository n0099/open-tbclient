package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a kaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.kaq = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.kaq.cEy()) {
            for (a.InterfaceC0456a interfaceC0456a : this.kaq.cEy()) {
                interfaceC0456a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.kaq.cEy()) {
            for (a.InterfaceC0456a interfaceC0456a : this.kaq.cEy()) {
                interfaceC0456a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.kaq.cEy()) {
            for (a.InterfaceC0456a interfaceC0456a : this.kaq.cEy()) {
                interfaceC0456a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.kaq.cEy()) {
            Iterator<a.InterfaceC0456a> it = this.kaq.cEy().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.kaq.cEy()) {
            Iterator<a.InterfaceC0456a> it = this.kaq.cEy().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.kaq.cEy()) {
            Iterator<a.InterfaceC0456a> it = this.kaq.cEy().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.kaq.cEy()) {
            for (a.InterfaceC0456a interfaceC0456a : this.kaq.cEy()) {
                interfaceC0456a.onActivityDestroyed(activity);
            }
        }
    }
}
