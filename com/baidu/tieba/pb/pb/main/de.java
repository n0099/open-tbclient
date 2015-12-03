package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class de implements Animation.AnimationListener {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(da daVar) {
        this.cGh = daVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        View view;
        boolean z2;
        z = this.cGh.cFx;
        if (!z) {
            kVar = this.cGh.KS;
            if (kVar != null) {
                kVar2 = this.cGh.KS;
                kVar2.oD();
                return;
            }
            return;
        }
        view = this.cGh.cFt;
        if (view != null) {
            z2 = this.cGh.cFr;
            if (z2) {
                this.cGh.fl(false);
            } else {
                this.cGh.fm(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
