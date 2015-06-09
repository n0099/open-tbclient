package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class ad implements Animation.AnimationListener {
    private final /* synthetic */ ae crk;
    private final /* synthetic */ ViewGroup crl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ae aeVar, ViewGroup viewGroup) {
        this.crk = aeVar;
        this.crl = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.crk != null) {
            this.crk.aoa();
        }
        this.crl.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.crl.setVisibility(8);
        if (this.crk != null) {
            this.crk.aob();
        }
    }
}
