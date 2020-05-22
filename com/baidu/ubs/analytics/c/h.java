package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a mhV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.mhV = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.mhV.dsp()) {
            for (a.InterfaceC0765a interfaceC0765a : this.mhV.dsp()) {
                interfaceC0765a.Nl();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.mhV.dsp()) {
            for (a.InterfaceC0765a interfaceC0765a : this.mhV.dsp()) {
                interfaceC0765a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.mhV.dsp()) {
            for (a.InterfaceC0765a interfaceC0765a : this.mhV.dsp()) {
                interfaceC0765a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.mhV.dsp()) {
            Iterator<a.InterfaceC0765a> it = this.mhV.dsp().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.mhV.dsp()) {
            Iterator<a.InterfaceC0765a> it = this.mhV.dsp().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.mhV.dsp()) {
            Iterator<a.InterfaceC0765a> it = this.mhV.dsp().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.mhV.dsp()) {
            for (a.InterfaceC0765a interfaceC0765a : this.mhV.dsp()) {
                interfaceC0765a.onActivityDestroyed(activity);
            }
        }
    }
}
