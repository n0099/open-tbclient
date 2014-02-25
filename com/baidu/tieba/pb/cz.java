package com.baidu.tieba.pb;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements Animation.AnimationListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.a.f.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
