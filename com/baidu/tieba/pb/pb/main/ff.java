package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ff implements Animation.AnimationListener {
    final /* synthetic */ ey eCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(ey eyVar) {
        this.eCT = eyVar;
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
        z = this.eCT.eBU;
        if (!z) {
            lVar = this.eCT.EL;
            if (lVar != null) {
                lVar2 = this.eCT.EL;
                lVar2.lz();
                return;
            }
            return;
        }
        view = this.eCT.eBP;
        if (view != null) {
            z2 = this.eCT.dEi;
            if (z2 && !this.eCT.aSF()) {
                this.eCT.gZ(false);
            } else {
                this.eCT.ha(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
