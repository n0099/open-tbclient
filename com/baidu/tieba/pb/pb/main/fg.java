package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fg implements Animation.AnimationListener {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fg(ey eyVar) {
        this.erv = eyVar;
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
        z = this.erv.eqt;
        if (!z) {
            jVar = this.erv.KM;
            if (jVar != null) {
                jVar2 = this.erv.KM;
                jVar2.mp();
                return;
            }
            return;
        }
        view = this.erv.eqo;
        if (view != null) {
            z2 = this.erv.dpj;
            if (z2) {
                this.erv.gD(false);
            } else {
                this.erv.gE(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
