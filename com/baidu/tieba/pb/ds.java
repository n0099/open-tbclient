package com.baidu.tieba.pb;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ds implements Animation.AnimationListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(cr crVar) {
        this.a = crVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        PbEditor pbEditor;
        pbEditor = this.a.ap;
        pbEditor.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
