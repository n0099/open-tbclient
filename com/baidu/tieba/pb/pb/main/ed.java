package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ed implements Animation.AnimationListener {
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ed(dz dzVar) {
        this.cSw = dzVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        com.baidu.tbadk.editortools.k kVar;
        View view2;
        com.baidu.tbadk.editortools.k kVar2;
        dz dzVar = this.cSw;
        view = this.cSw.cRx;
        dzVar.cRB = view.getVisibility() == 0;
        kVar = this.cSw.Lx;
        if (kVar != null) {
            kVar2 = this.cSw.Lx;
            kVar2.hide();
        }
        view2 = this.cSw.cRx;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
