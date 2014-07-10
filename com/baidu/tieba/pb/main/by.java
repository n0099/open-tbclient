package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by implements Animation.AnimationListener {
    final /* synthetic */ bt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bt btVar) {
        this.a = btVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        View view;
        View view2;
        z = this.a.aP;
        if (z) {
            view = this.a.aJ;
            view.setVisibility(0);
            view2 = this.a.aI;
            view2.setVisibility(0);
            return;
        }
        this.a.h.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
