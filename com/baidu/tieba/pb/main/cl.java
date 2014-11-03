package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class cl implements Animation.AnimationListener {
    final /* synthetic */ bv byW;
    private final /* synthetic */ ImageView bze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(bv bvVar, ImageView imageView) {
        this.byW = bvVar;
        this.bze = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new cm(this, this.bze));
    }
}
