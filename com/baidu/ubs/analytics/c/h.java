package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a jXT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.jXT = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.jXT.cDK()) {
            for (a.InterfaceC0445a interfaceC0445a : this.jXT.cDK()) {
                interfaceC0445a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.jXT.cDK()) {
            for (a.InterfaceC0445a interfaceC0445a : this.jXT.cDK()) {
                interfaceC0445a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.jXT.cDK()) {
            for (a.InterfaceC0445a interfaceC0445a : this.jXT.cDK()) {
                interfaceC0445a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.jXT.cDK()) {
            Iterator<a.InterfaceC0445a> it = this.jXT.cDK().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.jXT.cDK()) {
            Iterator<a.InterfaceC0445a> it = this.jXT.cDK().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.jXT.cDK()) {
            Iterator<a.InterfaceC0445a> it = this.jXT.cDK().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.jXT.cDK()) {
            for (a.InterfaceC0445a interfaceC0445a : this.jXT.cDK()) {
                interfaceC0445a.onActivityDestroyed(activity);
            }
        }
    }
}
