package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn implements Animation.AnimationListener {
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dk dkVar) {
        this.cKg = dkVar;
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
        dk dkVar = this.cKg;
        view = this.cKg.cJs;
        dkVar.cJw = view.getVisibility() == 0;
        kVar = this.cKg.Li;
        if (kVar != null) {
            kVar2 = this.cKg.Li;
            kVar2.hide();
        }
        view2 = this.cKg.cJs;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
