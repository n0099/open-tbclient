package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class az implements Animation.AnimationListener {
    private final /* synthetic */ ba bXc;
    private final /* synthetic */ ViewGroup bXd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ba baVar, ViewGroup viewGroup) {
        this.bXc = baVar;
        this.bXd = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.bXc != null) {
            this.bXc.agp();
        }
        this.bXd.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bXd.setVisibility(8);
        if (this.bXc != null) {
            this.bXc.agq();
        }
    }
}
