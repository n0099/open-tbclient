package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class x implements Animation.AnimationListener {
    final /* synthetic */ t eJi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.eJi = tVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        Animation animation2;
        Animation animation3;
        view = this.eJi.eJb;
        animation2 = this.eJi.eJf;
        view.setAnimation(animation2);
        animation3 = this.eJi.eJf;
        animation3.start();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
