package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ex implements Animation.AnimationListener {
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ex(er erVar) {
        this.egZ = erVar;
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
        er erVar = this.egZ;
        view = this.egZ.efV;
        erVar.ega = view.getVisibility() == 0;
        jVar = this.egZ.EM;
        if (jVar != null) {
            jVar2 = this.egZ.EM;
            jVar2.hide();
        }
        view2 = this.egZ.efV;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
