package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class hd implements Animation.AnimationListener {
    final /* synthetic */ gg eEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hd(gg ggVar) {
        this.eEv = ggVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView;
        ScaleAnimation scaleAnimation = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setStartOffset(300L);
        scaleAnimation.setAnimationListener(new he(this));
        textView = this.eEv.eDE;
        textView.startAnimation(scaleAnimation);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
