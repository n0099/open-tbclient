package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fc implements Animation.AnimationListener {
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(ew ewVar) {
        this.eiu = ewVar;
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
        ew ewVar = this.eiu;
        view = this.eiu.eho;
        ewVar.eht = view.getVisibility() == 0;
        lVar = this.eiu.Cw;
        if (lVar != null) {
            lVar2 = this.eiu.Cw;
            lVar2.hide();
        }
        view2 = this.eiu.eho;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
