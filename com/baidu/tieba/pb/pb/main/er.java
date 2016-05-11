package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class er implements Animation.AnimationListener {
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public er(el elVar) {
        this.dpu = elVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        com.baidu.tbadk.editortools.l lVar;
        View view2;
        com.baidu.tbadk.editortools.l lVar2;
        el elVar = this.dpu;
        view = this.dpu.doq;
        elVar.dov = view.getVisibility() == 0;
        lVar = this.dpu.BV;
        if (lVar != null) {
            lVar2 = this.dpu.BV;
            lVar2.hide();
        }
        view2 = this.dpu.doq;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
