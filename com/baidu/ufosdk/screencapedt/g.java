package com.baidu.ufosdk.screencapedt;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes7.dex */
final class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f5402a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ScreenCapEditActivity screenCapEditActivity) {
        this.f5402a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        Bitmap bitmap;
        Handler handler;
        imageView = this.f5402a.e;
        if (imageView != null) {
            bitmap = this.f5402a.g;
            if (bitmap != null) {
                this.f5402a.a(true);
                handler = this.f5402a.N;
                handler.obtainMessage(0).sendToTarget();
            }
        }
    }
}
