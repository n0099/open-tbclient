package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fd implements Animation.AnimationListener {
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fd(ex exVar) {
        this.euB = exVar;
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
        ex exVar = this.euB;
        view = this.euB.etv;
        exVar.etA = view.getVisibility() == 0;
        lVar = this.euB.EJ;
        if (lVar != null) {
            lVar2 = this.euB.EJ;
            lVar2.hide();
        }
        view2 = this.euB.etv;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
