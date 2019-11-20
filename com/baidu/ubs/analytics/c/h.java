package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a jXz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.jXz = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.jXz.cBg()) {
            for (a.InterfaceC0551a interfaceC0551a : this.jXz.cBg()) {
                interfaceC0551a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.jXz.cBg()) {
            for (a.InterfaceC0551a interfaceC0551a : this.jXz.cBg()) {
                interfaceC0551a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.jXz.cBg()) {
            for (a.InterfaceC0551a interfaceC0551a : this.jXz.cBg()) {
                interfaceC0551a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.jXz.cBg()) {
            Iterator<a.InterfaceC0551a> it = this.jXz.cBg().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.jXz.cBg()) {
            Iterator<a.InterfaceC0551a> it = this.jXz.cBg().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.jXz.cBg()) {
            Iterator<a.InterfaceC0551a> it = this.jXz.cBg().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.jXz.cBg()) {
            for (a.InterfaceC0551a interfaceC0551a : this.jXz.cBg()) {
                interfaceC0551a.onActivityDestroyed(activity);
            }
        }
    }
}
