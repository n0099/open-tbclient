package com.baidu.ubs.analytics.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.baidu.ubs.analytics.c.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Application.ActivityLifecycleCallbacks {
    private a jwT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.jwT = aVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        synchronized (this.jwT.css()) {
            for (a.InterfaceC0421a interfaceC0421a : this.jwT.css()) {
                interfaceC0421a.T();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        synchronized (this.jwT.css()) {
            for (a.InterfaceC0421a interfaceC0421a : this.jwT.css()) {
                interfaceC0421a.U();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.jwT.css()) {
            for (a.InterfaceC0421a interfaceC0421a : this.jwT.css()) {
                interfaceC0421a.a(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        synchronized (this.jwT.css()) {
            Iterator<a.InterfaceC0421a> it = this.jwT.css().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        synchronized (this.jwT.css()) {
            Iterator<a.InterfaceC0421a> it = this.jwT.css().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.jwT.css()) {
            Iterator<a.InterfaceC0421a> it = this.jwT.css().iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.jwT.css()) {
            for (a.InterfaceC0421a interfaceC0421a : this.jwT.css()) {
                interfaceC0421a.onActivityDestroyed(activity);
            }
        }
    }
}
