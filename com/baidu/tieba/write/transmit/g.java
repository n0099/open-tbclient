package com.baidu.tieba.write.transmit;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class g implements Animation.AnimationListener {
    final /* synthetic */ TransmitForumActivity ghI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(TransmitForumActivity transmitForumActivity) {
        this.ghI = transmitForumActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.ghI.finish();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
