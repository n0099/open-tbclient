package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cd implements Animation.AnimationListener {
    final /* synthetic */ cb cfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cb cbVar) {
        this.cfj = cbVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        com.baidu.tbadk.editortools.j jVar;
        View view2;
        com.baidu.tbadk.editortools.j jVar2;
        cb cbVar = this.cfj;
        view = this.cfj.ceN;
        cbVar.ceR = view.getVisibility() == 0;
        jVar = this.cfj.Kz;
        if (jVar != null) {
            jVar2 = this.cfj.Kz;
            jVar2.hide();
        }
        view2 = this.cfj.ceN;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
