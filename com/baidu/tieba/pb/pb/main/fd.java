package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fd implements Animation.AnimationListener {
    final /* synthetic */ ey erv;
    private final /* synthetic */ View erx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fd(ey eyVar, View view) {
        this.erv = eyVar;
        this.erx = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.erv.eoV.setTitleVisibility(false);
        this.erx.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.erv.epG;
        observedChangeLinearLayout.setVisibility(8);
        this.erv.eoV.setTitleVisibility(true);
        this.erx.setVisibility(8);
        this.erv.iJ(true);
        this.erv.aNF();
        pbActivity = this.erv.eig;
        pbActivity.im(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
