package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements Animation.AnimationListener {
    final /* synthetic */ cb cgg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cb cbVar) {
        this.cgg = cbVar;
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
        z = this.cgg.cfO;
        if (!z) {
            jVar = this.cgg.Kz;
            if (jVar != null) {
                jVar2 = this.cgg.Kz;
                jVar2.ov();
                return;
            }
            return;
        }
        view = this.cgg.cfK;
        if (view != null) {
            z2 = this.cgg.cfI;
            if (z2) {
                this.cgg.ez(false);
            } else {
                this.cgg.eA(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
