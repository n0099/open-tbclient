package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class x implements Animation.AnimationListener {
    final /* synthetic */ t eJt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.eJt = tVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        Animation animation2;
        Animation animation3;
        view = this.eJt.eJm;
        animation2 = this.eJt.eJq;
        view.setAnimation(animation2);
        animation3 = this.eJt.eJq;
        animation3.start();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
