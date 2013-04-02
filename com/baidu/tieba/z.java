package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        AlphaAnimation alphaAnimation;
        this.a.g = com.baidu.tieba.c.e.a(this.a, (int) R.drawable.logo);
        imageView = this.a.f;
        bitmap = this.a.g;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.a.f;
        alphaAnimation = this.a.h;
        imageView2.startAnimation(alphaAnimation);
    }
}
