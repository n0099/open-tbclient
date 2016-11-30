package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fe implements Animation.AnimationListener {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(ey eyVar) {
        this.eCT = eyVar;
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
        ey eyVar = this.eCT;
        view = this.eCT.eBP;
        eyVar.eBU = view.getVisibility() == 0;
        lVar = this.eCT.EL;
        if (lVar != null) {
            lVar2 = this.eCT.EL;
            lVar2.hide();
        }
        view2 = this.eCT.eBP;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
