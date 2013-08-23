package com.baidu.tieba;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LogoActivity f1763a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LogoActivity logoActivity) {
        this.f1763a = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        ImageView imageView;
        Bitmap bitmap;
        ImageView imageView2;
        AlphaAnimation alphaAnimation;
        this.f1763a.e = com.baidu.tieba.util.e.a(this.f1763a, (int) R.drawable.logo);
        imageView = this.f1763a.d;
        bitmap = this.f1763a.e;
        imageView.setImageBitmap(bitmap);
        imageView2 = this.f1763a.d;
        alphaAnimation = this.f1763a.f;
        imageView2.startAnimation(alphaAnimation);
    }
}
