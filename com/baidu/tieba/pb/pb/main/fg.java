package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fg implements Animation.AnimationListener {
    final /* synthetic */ ey etN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(ey eyVar) {
        this.etN = eyVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        View view;
        boolean z2;
        z = this.etN.esK;
        if (!z) {
            jVar = this.etN.KO;
            if (jVar != null) {
                jVar2 = this.etN.KO;
                jVar2.mp();
                return;
            }
            return;
        }
        view = this.etN.esF;
        if (view != null) {
            z2 = this.etN.drA;
            if (z2) {
                this.etN.gN(false);
            } else {
                this.etN.gO(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
