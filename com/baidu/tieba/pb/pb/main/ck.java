package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Animation.AnimationListener {
    final /* synthetic */ ci bMm;
    private final /* synthetic */ View bMn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ci ciVar, View view) {
        this.bMm = ciVar;
        this.bMn = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bMn.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.bMm.bLh;
        relativeLayout.setVisibility(8);
        this.bMn.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
