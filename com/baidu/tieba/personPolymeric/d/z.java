package com.baidu.tieba.personPolymeric.d;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class z implements Animation.AnimationListener {
    final /* synthetic */ w eYj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(w wVar) {
        this.eYj = wVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        Animation animation2;
        Animation animation3;
        view = this.eYj.eYa;
        animation2 = this.eYj.eYf;
        view.setAnimation(animation2);
        animation3 = this.eYj.eYf;
        animation3.start();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
