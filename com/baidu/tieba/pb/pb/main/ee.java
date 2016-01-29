package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ee implements Animation.AnimationListener {
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(dz dzVar) {
        this.cSw = dzVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        View view;
        boolean z2;
        z = this.cSw.cRB;
        if (!z) {
            kVar = this.cSw.Lx;
            if (kVar != null) {
                kVar2 = this.cSw.Lx;
                kVar2.ow();
                return;
            }
            return;
        }
        view = this.cSw.cRx;
        if (view != null) {
            z2 = this.cSw.crE;
            if (z2) {
                this.cSw.er(false);
            } else {
                this.cSw.es(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
