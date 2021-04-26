package com.baidu.wallet.core;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.OrientationEventListener;
/* loaded from: classes5.dex */
public class b extends OrientationEventListener {

    /* renamed from: a  reason: collision with root package name */
    public Context f24655a;

    public b(Context context) {
        super(context);
        this.f24655a = context;
    }

    public void a() {
        disable();
        this.f24655a = null;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i2) {
        Context context = this.f24655a;
        if (context instanceof Activity) {
            if (Build.VERSION.SDK_INT != 26 || context.getApplicationInfo().targetSdkVersion <= 26) {
                ((Activity) this.f24655a).setRequestedOrientation(1);
            }
        }
    }
}
