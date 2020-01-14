package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a kVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.kVC = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.kVC.cWd()) {
            for (a.InterfaceC0634a interfaceC0634a : this.kVC.cWd()) {
                interfaceC0634a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.kVC.cWd()) {
            for (a.InterfaceC0634a interfaceC0634a : this.kVC.cWd()) {
                interfaceC0634a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.kVC.cWd()) {
            for (a.InterfaceC0634a interfaceC0634a : this.kVC.cWd()) {
                interfaceC0634a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.kVC.cWd()) {
            Iterator<a.InterfaceC0634a> it = this.kVC.cWd().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.kVC.cWd()) {
            Iterator<a.InterfaceC0634a> it = this.kVC.cWd().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.kVC.cWd()) {
            Iterator<a.InterfaceC0634a> it = this.kVC.cWd().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.kVC.cWd()) {
            for (a.InterfaceC0634a interfaceC0634a : this.kVC.cWd()) {
                interfaceC0634a.onActivityDestroyed(activity);
            }
        }
    }
}
