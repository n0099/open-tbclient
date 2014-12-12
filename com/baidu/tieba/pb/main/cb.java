package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements Animation.AnimationListener {
    final /* synthetic */ bz bCR;
    private final /* synthetic */ View bCS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bz bzVar, View view) {
        this.bCR = bzVar;
        this.bCS = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bCS.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.bCR.bBI;
        relativeLayout.setVisibility(8);
        this.bCS.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
