package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ff implements Animation.AnimationListener {
    final /* synthetic */ ey etN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(ey eyVar) {
        this.etN = eyVar;
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
        ey eyVar = this.etN;
        view = this.etN.esF;
        eyVar.esK = view.getVisibility() == 0;
        jVar = this.etN.KO;
        if (jVar != null) {
            jVar2 = this.etN.KO;
            jVar2.hide();
        }
        view2 = this.etN.esF;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
