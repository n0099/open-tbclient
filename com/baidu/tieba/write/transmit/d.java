package com.baidu.tieba.write.transmit;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class d implements Animation.AnimationListener {
    final /* synthetic */ TransmitForumActivity fOL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TransmitForumActivity transmitForumActivity) {
        this.fOL = transmitForumActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.fOL.finish();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
