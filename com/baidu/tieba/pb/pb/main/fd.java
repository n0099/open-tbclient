package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fd implements Animation.AnimationListener {
    final /* synthetic */ ey etN;
    private final /* synthetic */ View etP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fd(ey eyVar, View view) {
        this.etN = eyVar;
        this.etP = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.etN.erm.setTitleVisibility(false);
        this.etP.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.etN.erX;
        observedChangeLinearLayout.setVisibility(8);
        this.etN.erm.setTitleVisibility(true);
        this.etP.setVisibility(8);
        this.etN.iT(true);
        this.etN.aOG();
        pbActivity = this.etN.ekw;
        pbActivity.iw(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
