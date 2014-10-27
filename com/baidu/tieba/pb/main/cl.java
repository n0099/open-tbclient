package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class cl implements Animation.AnimationListener {
    final /* synthetic */ bv byI;
    private final /* synthetic */ ImageView byQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(bv bvVar, ImageView imageView) {
        this.byI = bvVar;
        this.byQ = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new cm(this, this.byQ));
    }
}
