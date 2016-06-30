package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ez implements Animation.AnimationListener {
    final /* synthetic */ es dVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ez(es esVar) {
        this.dVR = esVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        View view;
        boolean z2;
        z = this.dVR.dUS;
        if (!z) {
            lVar = this.dVR.BW;
            if (lVar != null) {
                lVar2 = this.dVR.BW;
                lVar2.kF();
                return;
            }
            return;
        }
        view = this.dVR.dUN;
        if (view != null) {
            z2 = this.dVR.diC;
            if (z2 && !this.dVR.aHZ()) {
                this.dVR.gd(false);
            } else {
                this.dVR.ge(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
