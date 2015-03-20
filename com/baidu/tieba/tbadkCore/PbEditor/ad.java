package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class ad implements Animation.AnimationListener {
    private final /* synthetic */ ae cmV;
    private final /* synthetic */ ViewGroup cmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ae aeVar, ViewGroup viewGroup) {
        this.cmV = aeVar;
        this.cmW = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.cmV != null) {
            this.cmV.alY();
        }
        this.cmW.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cmW.setVisibility(8);
        if (this.cmV != null) {
            this.cmV.alZ();
        }
    }
}
