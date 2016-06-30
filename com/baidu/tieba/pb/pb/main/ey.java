package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ey implements Animation.AnimationListener {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ey(es esVar) {
        this.dVR = esVar;
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
        es esVar = this.dVR;
        view = this.dVR.dUN;
        esVar.dUS = view.getVisibility() == 0;
        lVar = this.dVR.BW;
        if (lVar != null) {
            lVar2 = this.dVR.BW;
            lVar2.hide();
        }
        view2 = this.dVR.dUN;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
