package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements Animation.AnimationListener {
    final /* synthetic */ cj bMC;
    private final /* synthetic */ View bMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cj cjVar, View view) {
        this.bMC = cjVar;
        this.bMD = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bMD.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.bMC.bLw;
        relativeLayout.setVisibility(8);
        this.bMD.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
