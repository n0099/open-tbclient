package com.baidu.ufosdk.screencapedt;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public final class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenCapEditActivity f23381a;

    public f(ScreenCapEditActivity screenCapEditActivity) {
        this.f23381a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        Bitmap bitmap;
        Handler handler;
        imageView = this.f23381a.f23364e;
        if (imageView != null) {
            bitmap = this.f23381a.f23366g;
            if (bitmap != null) {
                this.f23381a.a(true);
                handler = this.f23381a.N;
                handler.obtainMessage(0).sendToTarget();
            }
        }
    }
}
