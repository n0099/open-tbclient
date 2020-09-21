package com.baidu.ufosdk.screencapedt;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes21.dex */
final class f implements View.OnClickListener {
    final /* synthetic */ ScreenCapEditActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ScreenCapEditActivity screenCapEditActivity) {
        this.a = screenCapEditActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ImageView imageView;
        Bitmap bitmap;
        Handler handler;
        imageView = this.a.e;
        if (imageView != null) {
            bitmap = this.a.g;
            if (bitmap != null) {
                this.a.a(true);
                handler = this.a.N;
                handler.obtainMessage(0).sendToTarget();
            }
        }
    }
}
