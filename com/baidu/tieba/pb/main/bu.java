package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bu implements Animation.AnimationListener {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bm bmVar) {
        this.a = bmVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        boolean z;
        View view;
        View view2;
        z = this.a.aR;
        if (z) {
            view = this.a.aL;
            view.setVisibility(0);
            view2 = this.a.aK;
            view2.setVisibility(0);
            return;
        }
        this.a.j.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }
}
