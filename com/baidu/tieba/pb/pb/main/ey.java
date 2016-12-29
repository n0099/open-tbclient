package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ey implements Animation.AnimationListener {
    final /* synthetic */ er egZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ey(er erVar) {
        this.egZ = erVar;
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
        z = this.egZ.ega;
        if (!z) {
            jVar = this.egZ.EM;
            if (jVar != null) {
                jVar2 = this.egZ.EM;
                jVar2.lz();
                return;
            }
            return;
        }
        view = this.egZ.efV;
        if (view != null) {
            z2 = this.egZ.dhg;
            if (z2) {
                this.egZ.gJ(false);
            } else {
                this.egZ.gK(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
