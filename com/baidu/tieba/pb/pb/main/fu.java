package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fu implements Animation.AnimationListener {
    final /* synthetic */ fm epr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fu(fm fmVar) {
        this.epr = fmVar;
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
        z = this.epr.eot;
        if (!z) {
            jVar = this.epr.Kg;
            if (jVar != null) {
                jVar2 = this.epr.Kg;
                jVar2.lW();
                return;
            }
            return;
        }
        view = this.epr.eoo;
        if (view != null) {
            z2 = this.epr.dlE;
            if (z2) {
                this.epr.go(false);
            } else {
                this.epr.gp(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
