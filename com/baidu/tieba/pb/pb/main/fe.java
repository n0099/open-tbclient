package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fe implements Animation.AnimationListener {
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(ex exVar) {
        this.euB = exVar;
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
        z = this.euB.etA;
        if (!z) {
            lVar = this.euB.EJ;
            if (lVar != null) {
                lVar2 = this.euB.EJ;
                lVar2.lw();
                return;
            }
            return;
        }
        view = this.euB.etv;
        if (view != null) {
            z2 = this.euB.dxj;
            if (z2 && !this.euB.aQa()) {
                this.euB.gC(false);
            } else {
                this.euB.gD(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
