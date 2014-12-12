package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class cp implements Animation.AnimationListener {
    final /* synthetic */ bz bCR;
    private final /* synthetic */ ImageView bDa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(bz bzVar, ImageView imageView) {
        this.bCR = bzVar;
        this.bDa = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new cq(this, this.bDa));
    }
}
