package com.baidu.tieba.tbadkCore.PbEditor;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class az implements Animation.AnimationListener {
    private final /* synthetic */ ba bVk;
    private final /* synthetic */ ViewGroup bVl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ba baVar, ViewGroup viewGroup) {
        this.bVk = baVar;
        this.bVl = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.bVk != null) {
            this.bVk.afL();
        }
        this.bVl.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bVl.setVisibility(8);
        if (this.bVk != null) {
            this.bVk.afM();
        }
    }
}
