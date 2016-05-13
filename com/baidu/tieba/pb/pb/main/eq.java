package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import com.baidu.tbadk.widget.layout.ObservedChangeLinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eq implements Animation.AnimationListener {
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(el elVar) {
        this.dpu = elVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.dpu.dmZ.setTitleVisibility(false);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ObservedChangeLinearLayout observedChangeLinearLayout;
        boolean z;
        PbActivity pbActivity;
        observedChangeLinearLayout = this.dpu.dnI;
        observedChangeLinearLayout.setVisibility(0);
        this.dpu.dmZ.setTitleVisibility(true);
        this.dpu.gS(false);
        z = this.dpu.doV;
        if (z) {
            this.dpu.azD();
        }
        pbActivity = this.dpu.dhY;
        pbActivity.gz(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
