package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ep implements Animation.AnimationListener {
    final /* synthetic */ el dpu;
    private final /* synthetic */ View dpw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ep(el elVar, View view) {
        this.dpu = elVar;
        this.dpw = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.dpu.dmZ.setTitleVisibility(false);
        this.dpw.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.dpu.dnI;
        observedChangeLinearLayout.setVisibility(8);
        this.dpu.dmZ.setTitleVisibility(true);
        this.dpw.setVisibility(8);
        this.dpu.gS(true);
        this.dpu.azz();
        pbActivity = this.dpu.dhY;
        pbActivity.gz(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
