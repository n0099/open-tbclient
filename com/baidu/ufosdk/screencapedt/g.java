package com.baidu.ufosdk.screencapedt;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public final class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f22670a;

    public g(ScreenCapEditActivity screenCapEditActivity) {
        this.f22670a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        Bitmap bitmap;
        Handler handler;
        imageView = this.f22670a.f22653e;
        if (imageView != null) {
            bitmap = this.f22670a.f22655g;
            if (bitmap != null) {
                this.f22670a.a(true);
                handler = this.f22670a.N;
                handler.obtainMessage(0).sendToTarget();
            }
        }
    }
}
