package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class ci implements Animation.AnimationListener {
    final /* synthetic */ bt a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(bt btVar, ImageView imageView) {
        this.a = btVar;
        this.b = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new cj(this, this.b));
    }
}
