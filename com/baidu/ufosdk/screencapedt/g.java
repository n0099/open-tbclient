package com.baidu.ufosdk.screencapedt;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes22.dex */
final class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f3728a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ScreenCapEditActivity screenCapEditActivity) {
        this.f3728a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        Bitmap bitmap;
        Handler handler;
        imageView = this.f3728a.e;
        if (imageView != null) {
            bitmap = this.f3728a.g;
            if (bitmap != null) {
                this.f3728a.a(true);
                handler = this.f3728a.N;
                handler.obtainMessage(0).sendToTarget();
            }
        }
    }
}
