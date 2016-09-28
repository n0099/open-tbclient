package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fe implements Animation.AnimationListener {
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fe(ex exVar) {
        this.ewH = exVar;
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
        z = this.ewH.evI;
        if (!z) {
            lVar = this.ewH.EJ;
            if (lVar != null) {
                lVar2 = this.ewH.EJ;
                lVar2.lw();
                return;
            }
            return;
        }
        view = this.ewH.evD;
        if (view != null) {
            z2 = this.ewH.dyE;
            if (z2 && !this.ewH.aQJ()) {
                this.ewH.gF(false);
            } else {
                this.ewH.gG(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
