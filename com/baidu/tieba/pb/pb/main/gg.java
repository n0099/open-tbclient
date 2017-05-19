package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gg implements Animation.AnimationListener {
    final /* synthetic */ fm epr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gg(fm fmVar) {
        this.epr = fmVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.epr.emS != null) {
            this.epr.emS.aMs();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
