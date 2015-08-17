package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements Animation.AnimationListener {
    final /* synthetic */ cb cfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cb cbVar) {
        this.cfj = cbVar;
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
        z = this.cfj.ceR;
        if (!z) {
            jVar = this.cfj.Kz;
            if (jVar != null) {
                jVar2 = this.cfj.Kz;
                jVar2.oy();
                return;
            }
            return;
        }
        view = this.cfj.ceN;
        if (view != null) {
            z2 = this.cfj.ceL;
            if (z2) {
                this.cfj.er(false);
            } else {
                this.cfj.es(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
