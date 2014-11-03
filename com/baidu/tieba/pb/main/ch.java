package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class ch implements Animation.AnimationListener {
    final /* synthetic */ bv byW;
    private final /* synthetic */ ImageView byX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(bv bvVar, ImageView imageView) {
        this.byW = bvVar;
        this.byX = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new ci(this, this.byX));
    }
}
