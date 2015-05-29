package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class ad implements Animation.AnimationListener {
    private final /* synthetic */ ae crj;
    private final /* synthetic */ ViewGroup crk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ae aeVar, ViewGroup viewGroup) {
        this.crj = aeVar;
        this.crk = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.crj != null) {
            this.crj.anZ();
        }
        this.crk.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.crk.setVisibility(8);
        if (this.crj != null) {
            this.crj.aoa();
        }
    }
}
