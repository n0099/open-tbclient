package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f2134a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LogoActivity logoActivity) {
        this.f2134a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        AlphaAnimation alphaAnimation;
        this.f2134a.e = com.baidu.tieba.util.e.a(this.f2134a, (int) R.drawable.logo);
        imageView = this.f2134a.d;
        bitmap = this.f2134a.e;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.f2134a.d;
        alphaAnimation = this.f2134a.f;
        imageView2.startAnimation(alphaAnimation);
    }
}
