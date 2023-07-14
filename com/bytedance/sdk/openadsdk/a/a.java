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
    public InterfaceC0574a c;

    /* renamed from: com.bytedance.sdk.openadsdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0574a {
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

    public void a(InterfaceC0574a interfaceC0574a) {
        this.c = interfaceC0574a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        this.b++;
        a = false;
        InterfaceC0574a interfaceC0574a = this.c;
        if (interfaceC0574a != null) {
            interfaceC0574a.b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        int i = this.b - 1;
        this.b = i;
        if (i == 0) {
            a = true;
            InterfaceC0574a interfaceC0574a = this.c;
            if (interfaceC0574a != null) {
                interfaceC0574a.a();
            }
        }
    }
}
