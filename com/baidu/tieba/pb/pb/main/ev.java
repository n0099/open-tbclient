package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ev implements Animation.AnimationListener {
    final /* synthetic */ er egZ;
    private final /* synthetic */ View ehb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(er erVar, View view) {
        this.egZ = erVar;
        this.ehb = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.egZ.eeG.setTitleVisibility(false);
        this.ehb.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.egZ.efo;
        observedChangeLinearLayout.setVisibility(8);
        this.egZ.eeG.setTitleVisibility(true);
        this.ehb.setVisibility(8);
        this.egZ.iF(true);
        this.egZ.aMm();
        pbActivity = this.egZ.dYB;
        pbActivity.ii(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
