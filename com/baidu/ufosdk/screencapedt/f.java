package com.baidu.ufosdk.screencapedt;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public final class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f22555a;

    public f(ScreenCapEditActivity screenCapEditActivity) {
        this.f22555a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        Bitmap bitmap;
        Handler handler;
        imageView = this.f22555a.f22538e;
        if (imageView != null) {
            bitmap = this.f22555a.f22540g;
            if (bitmap != null) {
                this.f22555a.a(true);
                handler = this.f22555a.N;
                handler.obtainMessage(0).sendToTarget();
            }
        }
    }
}
