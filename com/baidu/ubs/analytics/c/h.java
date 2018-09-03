package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a hCJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.hCJ = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.hCJ.bJc()) {
            for (a.InterfaceC0263a interfaceC0263a : this.hCJ.bJc()) {
                interfaceC0263a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.hCJ.bJc()) {
            for (a.InterfaceC0263a interfaceC0263a : this.hCJ.bJc()) {
                interfaceC0263a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.hCJ.bJc()) {
            for (a.InterfaceC0263a interfaceC0263a : this.hCJ.bJc()) {
                interfaceC0263a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.hCJ.bJc()) {
            Iterator<a.InterfaceC0263a> it = this.hCJ.bJc().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.hCJ.bJc()) {
            Iterator<a.InterfaceC0263a> it = this.hCJ.bJc().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.hCJ.bJc()) {
            Iterator<a.InterfaceC0263a> it = this.hCJ.bJc().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.hCJ.bJc()) {
            for (a.InterfaceC0263a interfaceC0263a : this.hCJ.bJc()) {
                interfaceC0263a.onActivityDestroyed(activity);
            }
        }
    }
}
