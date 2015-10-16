package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements Animation.AnimationListener {
    final /* synthetic */ cc clJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(cc ccVar) {
        this.clJ = ccVar;
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
        z = this.clJ.cls;
        if (!z) {
            jVar = this.clJ.KA;
            if (jVar != null) {
                jVar2 = this.clJ.KA;
                jVar2.ow();
                return;
            }
            return;
        }
        view = this.clJ.clo;
        if (view != null) {
            z2 = this.clJ.clm;
            if (z2) {
                this.clJ.eE(false);
            } else {
                this.clJ.eF(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
