package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements Animation.AnimationListener {
    final /* synthetic */ bz bEB;
    private final /* synthetic */ View bEM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(bz bzVar, View view) {
        this.bEB = bzVar;
        this.bEM = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bEM.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.bEB.bDr;
        relativeLayout.setVisibility(8);
        this.bEM.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
