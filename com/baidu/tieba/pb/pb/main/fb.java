package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fb implements Animation.AnimationListener {
    final /* synthetic */ ex ewH;
    private final /* synthetic */ View ewJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(ex exVar, View view) {
        this.ewH = exVar;
        this.ewJ = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.ewH.eug.setTitleVisibility(false);
        this.ewJ.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.ewH.euW;
        observedChangeLinearLayout.setVisibility(8);
        this.ewH.eug.setTitleVisibility(true);
        this.ewJ.setVisibility(8);
        this.ewH.iv(true);
        this.ewH.aQy();
        pbActivity = this.ewH.eow;
        pbActivity.ic(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
