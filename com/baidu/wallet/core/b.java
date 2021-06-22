package com.baidu.wallet.core;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.OrientationEventListener;
/* loaded from: classes5.dex */
public class b extends OrientationEventListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f24014a;

    public b(Context context) {
        super(context);
        this.f24014a = context;
    }

    public void a() {
        disable();
        this.f24014a = null;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i2) {
        Context context = this.f24014a;
        if (context instanceof Activity) {
            if (Build.VERSION.SDK_INT != 26 || context.getApplicationInfo().targetSdkVersion <= 26) {
                ((Activity) this.f24014a).setRequestedOrientation(1);
            }
        }
    }
}
