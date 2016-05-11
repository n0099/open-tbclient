package com.baidu.tieba.recommendfrs.control;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Animation.AnimationListener {
    final /* synthetic */ m dZb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(m mVar) {
        this.dZb = mVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        View view3;
        view = this.dZb.dZa;
        if (view != null) {
            view2 = this.dZb.dZa;
            view2.clearAnimation();
            view3 = this.dZb.dZa;
            view3.setVisibility(0);
            this.dZb.cZ(false);
        }
    }
}
