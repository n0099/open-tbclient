package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Animation.AnimationListener {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bs bsVar) {
        this.a = bsVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        View view;
        View view2;
        z = this.a.aQ;
        if (z) {
            view = this.a.aK;
            view.setVisibility(0);
            view2 = this.a.aJ;
            view2.setVisibility(0);
            return;
        }
        this.a.h.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
