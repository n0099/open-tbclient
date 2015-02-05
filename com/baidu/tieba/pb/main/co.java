package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class co implements Animation.AnimationListener {
    final /* synthetic */ bz bEB;
    private final /* synthetic */ ImageView bEJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(bz bzVar, ImageView imageView) {
        this.bEB = bzVar;
        this.bEJ = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new cp(this, this.bEJ));
    }
}
