package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dd implements Animation.AnimationListener {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(da daVar) {
        this.cGh = daVar;
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
        da daVar = this.cGh;
        view = this.cGh.cFt;
        daVar.cFx = view.getVisibility() == 0;
        kVar = this.cGh.KS;
        if (kVar != null) {
            kVar2 = this.cGh.KS;
            kVar2.hide();
        }
        view2 = this.cGh.cFt;
        view2.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
