package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cx implements Animation.AnimationListener {
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(ct ctVar) {
        this.cmY = ctVar;
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
        z = this.cmY.cmG;
        if (!z) {
            jVar = this.cmY.KB;
            if (jVar != null) {
                jVar2 = this.cmY.KB;
                jVar2.ox();
                return;
            }
            return;
        }
        view = this.cmY.cmC;
        if (view != null) {
            z2 = this.cmY.cmA;
            if (z2) {
                this.cmY.eH(false);
            } else {
                this.cmY.eI(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
