package com.baidu.tieba.play;

import android.view.View;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class p implements Animation.AnimationListener {
    final /* synthetic */ c ffA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(c cVar) {
        this.ffA = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        view = this.ffA.aSJ;
        if (view != null) {
            view2 = this.ffA.aSJ;
            view2.setVisibility(8);
            this.ffA.ffb = false;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
