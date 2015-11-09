package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements Animation.AnimationListener {
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(ct ctVar) {
        this.cmY = ctVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        com.baidu.tbadk.editortools.j jVar;
        View view2;
        com.baidu.tbadk.editortools.j jVar2;
        ct ctVar = this.cmY;
        view = this.cmY.cmC;
        ctVar.cmG = view.getVisibility() == 0;
        jVar = this.cmY.KB;
        if (jVar != null) {
            jVar2 = this.cmY.KB;
            jVar2.hide();
        }
        view2 = this.cmY.cmC;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
