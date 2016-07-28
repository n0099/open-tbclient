package com.baidu.tieba.write.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Animation.AnimationListener {
    final /* synthetic */ a fSt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.fSt = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.fSt.blh();
    }
}
