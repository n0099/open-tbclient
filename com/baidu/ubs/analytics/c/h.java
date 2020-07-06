package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a mFe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.mFe = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.mFe.dxm()) {
            for (a.InterfaceC0786a interfaceC0786a : this.mFe.dxm()) {
                interfaceC0786a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.mFe.dxm()) {
            for (a.InterfaceC0786a interfaceC0786a : this.mFe.dxm()) {
                interfaceC0786a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.mFe.dxm()) {
            for (a.InterfaceC0786a interfaceC0786a : this.mFe.dxm()) {
                interfaceC0786a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.mFe.dxm()) {
            Iterator<a.InterfaceC0786a> it = this.mFe.dxm().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.mFe.dxm()) {
            Iterator<a.InterfaceC0786a> it = this.mFe.dxm().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.mFe.dxm()) {
            Iterator<a.InterfaceC0786a> it = this.mFe.dxm().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.mFe.dxm()) {
            for (a.InterfaceC0786a interfaceC0786a : this.mFe.dxm()) {
                interfaceC0786a.onActivityDestroyed(activity);
            }
        }
    }
}
