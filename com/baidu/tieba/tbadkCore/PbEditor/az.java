package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class az implements Animation.AnimationListener {
    private final /* synthetic */ ba bXb;
    private final /* synthetic */ ViewGroup bXc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ba baVar, ViewGroup viewGroup) {
        this.bXb = baVar;
        this.bXc = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.bXb != null) {
            this.bXb.agk();
        }
        this.bXc.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bXc.setVisibility(8);
        if (this.bXb != null) {
            this.bXb.agl();
        }
    }
}
