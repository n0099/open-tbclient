package com.baidu.tieba.pb.video;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    final /* synthetic */ l eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(l lVar) {
        this.eAW = lVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.eAW.aNC();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
