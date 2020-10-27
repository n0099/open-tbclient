package com.baidu.ufosdk.screencapedt;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes22.dex */
final class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f3727a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ScreenCapEditActivity screenCapEditActivity) {
        this.f3727a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        Bitmap bitmap;
        Handler handler;
        imageView = this.f3727a.e;
        if (imageView != null) {
            bitmap = this.f3727a.g;
            if (bitmap != null) {
                this.f3727a.a(true);
                handler = this.f3727a.N;
                handler.obtainMessage(0).sendToTarget();
            }
        }
    }
}
