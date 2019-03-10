package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a jxk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.jxk = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.jxk.csr()) {
            for (a.InterfaceC0328a interfaceC0328a : this.jxk.csr()) {
                interfaceC0328a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.jxk.csr()) {
            for (a.InterfaceC0328a interfaceC0328a : this.jxk.csr()) {
                interfaceC0328a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.jxk.csr()) {
            for (a.InterfaceC0328a interfaceC0328a : this.jxk.csr()) {
                interfaceC0328a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.jxk.csr()) {
            Iterator<a.InterfaceC0328a> it = this.jxk.csr().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.jxk.csr()) {
            Iterator<a.InterfaceC0328a> it = this.jxk.csr().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.jxk.csr()) {
            Iterator<a.InterfaceC0328a> it = this.jxk.csr().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.jxk.csr()) {
            for (a.InterfaceC0328a interfaceC0328a : this.jxk.csr()) {
                interfaceC0328a.onActivityDestroyed(activity);
            }
        }
    }
}
