package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class ad implements Animation.AnimationListener {
    private final /* synthetic */ ae cnl;
    private final /* synthetic */ ViewGroup cnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ae aeVar, ViewGroup viewGroup) {
        this.cnl = aeVar;
        this.cnm = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.cnl != null) {
            this.cnl.amn();
        }
        this.cnm.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cnm.setVisibility(8);
        if (this.cnl != null) {
            this.cnl.amo();
        }
    }
}
