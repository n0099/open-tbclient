package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ew implements Animation.AnimationListener {
    final /* synthetic */ es dVR;
    private final /* synthetic */ View dVT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ew(es esVar, View view) {
        this.dVR = esVar;
        this.dVT = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.dVR.dTq.setTitleVisibility(false);
        this.dVT.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.dVR.dUg;
        observedChangeLinearLayout.setVisibility(8);
        this.dVR.dTq.setTitleVisibility(true);
        this.dVT.setVisibility(8);
        this.dVR.hL(true);
        this.dVR.aHO();
        pbActivity = this.dVR.dOg;
        pbActivity.hs(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
