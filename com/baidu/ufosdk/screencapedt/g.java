package com.baidu.ufosdk.screencapedt;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes21.dex */
final class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScreenCapEditActivity f3730a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ScreenCapEditActivity screenCapEditActivity) {
        this.f3730a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        Bitmap bitmap;
        Handler handler;
        imageView = this.f3730a.e;
        if (imageView != null) {
            bitmap = this.f3730a.g;
            if (bitmap != null) {
                this.f3730a.a(true);
                handler = this.f3730a.N;
                handler.obtainMessage(0).sendToTarget();
            }
        }
    }
}
