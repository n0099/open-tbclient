package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements Animation.AnimationListener {
    final /* synthetic */ bz bEC;
    private final /* synthetic */ View bEN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(bz bzVar, View view) {
        this.bEC = bzVar;
        this.bEN = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bEN.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.bEC.bDs;
        relativeLayout.setVisibility(8);
        this.bEN.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
