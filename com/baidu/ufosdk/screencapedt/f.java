package com.baidu.ufosdk.screencapedt;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes22.dex */
final class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f3732a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ScreenCapEditActivity screenCapEditActivity) {
        this.f3732a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        Bitmap bitmap;
        Handler handler;
        imageView = this.f3732a.e;
        if (imageView != null) {
            bitmap = this.f3732a.g;
            if (bitmap != null) {
                this.f3732a.a(true);
                handler = this.f3732a.N;
                handler.obtainMessage(0).sendToTarget();
            }
        }
    }
}
