package com.bytedance.sdk.openadsdk.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    public static volatile boolean a;
    public int b = 0;
    public InterfaceC0568a c;

    /* renamed from: com.bytedance.sdk.openadsdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0568a {
        void a();

        void b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    public Boolean a() {
        return Boolean.valueOf(a);
    }

    public void a(InterfaceC0568a interfaceC0568a) {
        this.c = interfaceC0568a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        this.b++;
        a = false;
        InterfaceC0568a interfaceC0568a = this.c;
        if (interfaceC0568a != null) {
            interfaceC0568a.b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        int i = this.b - 1;
        this.b = i;
        if (i == 0) {
            a = true;
            InterfaceC0568a interfaceC0568a = this.c;
            if (interfaceC0568a != null) {
                interfaceC0568a.a();
            }
        }
    }
}
