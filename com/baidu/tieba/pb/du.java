package com.baidu.tieba.pb;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class du implements Animation.AnimationListener {
    final /* synthetic */ cs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(cs csVar) {
        this.a = csVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        PbEditor pbEditor;
        pbEditor = this.a.aq;
        pbEditor.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
