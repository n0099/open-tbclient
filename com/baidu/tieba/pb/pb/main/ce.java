package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce implements Animation.AnimationListener {
    final /* synthetic */ cc clJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cc ccVar) {
        this.clJ = ccVar;
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
        cc ccVar = this.clJ;
        view = this.clJ.clo;
        ccVar.cls = view.getVisibility() == 0;
        jVar = this.clJ.KA;
        if (jVar != null) {
            jVar2 = this.clJ.KA;
            jVar2.hide();
        }
        view2 = this.clJ.clo;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
