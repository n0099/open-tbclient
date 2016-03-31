package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fa implements Animation.AnimationListener {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(eu euVar) {
        this.dnc = euVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        com.baidu.tbadk.editortools.l lVar;
        View view2;
        com.baidu.tbadk.editortools.l lVar2;
        eu euVar = this.dnc;
        view = this.dnc.dlV;
        euVar.dmb = view.getVisibility() == 0;
        lVar = this.dnc.LE;
        if (lVar != null) {
            lVar2 = this.dnc.LE;
            lVar2.hide();
        }
        view2 = this.dnc.dlV;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
