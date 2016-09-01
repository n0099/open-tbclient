package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fb implements Animation.AnimationListener {
    final /* synthetic */ ex euB;
    private final /* synthetic */ View euD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(ex exVar, View view) {
        this.euB = exVar;
        this.euD = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.euB.erX.setTitleVisibility(false);
        this.euD.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.euB.esN;
        observedChangeLinearLayout.setVisibility(8);
        this.euB.erX.setTitleVisibility(true);
        this.euD.setVisibility(8);
        this.euB.is(true);
        this.euB.aPP();
        pbActivity = this.euB.emy;
        pbActivity.hZ(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
