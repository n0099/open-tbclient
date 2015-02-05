package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class ck implements Animation.AnimationListener {
    final /* synthetic */ bz bEB;
    private final /* synthetic */ ImageView bEC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(bz bzVar, ImageView imageView) {
        this.bEB = bzVar;
        this.bEC = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new cl(this, this.bEC));
    }
}
