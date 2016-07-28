package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fa implements Animation.AnimationListener {
    final /* synthetic */ ew eiu;
    private final /* synthetic */ View eiw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(ew ewVar, View view) {
        this.eiu = ewVar;
        this.eiw = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.eiu.efS.setTitleVisibility(false);
        this.eiw.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.eiu.egH;
        observedChangeLinearLayout.setVisibility(8);
        this.eiu.efS.setTitleVisibility(true);
        this.eiw.setVisibility(8);
        this.eiu.hX(true);
        this.eiu.aKY();
        pbActivity = this.eiu.eat;
        pbActivity.hD(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
