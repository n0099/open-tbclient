package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a hTY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.hTY = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.hTY.bQj()) {
            for (a.InterfaceC0306a interfaceC0306a : this.hTY.bQj()) {
                interfaceC0306a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.hTY.bQj()) {
            for (a.InterfaceC0306a interfaceC0306a : this.hTY.bQj()) {
                interfaceC0306a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.hTY.bQj()) {
            for (a.InterfaceC0306a interfaceC0306a : this.hTY.bQj()) {
                interfaceC0306a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.hTY.bQj()) {
            Iterator<a.InterfaceC0306a> it = this.hTY.bQj().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.hTY.bQj()) {
            Iterator<a.InterfaceC0306a> it = this.hTY.bQj().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.hTY.bQj()) {
            Iterator<a.InterfaceC0306a> it = this.hTY.bQj().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.hTY.bQj()) {
            for (a.InterfaceC0306a interfaceC0306a : this.hTY.bQj()) {
                interfaceC0306a.onActivityDestroyed(activity);
            }
        }
    }
}
