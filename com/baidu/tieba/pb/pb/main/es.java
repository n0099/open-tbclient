package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class es implements Animation.AnimationListener {
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public es(el elVar) {
        this.dpu = elVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        com.baidu.tbadk.editortools.l lVar;
        com.baidu.tbadk.editortools.l lVar2;
        View view;
        boolean z2;
        z = this.dpu.dov;
        if (!z) {
            lVar = this.dpu.BV;
            if (lVar != null) {
                lVar2 = this.dpu.BV;
                lVar2.kC();
                return;
            }
            return;
        }
        view = this.dpu.doq;
        if (view != null) {
            z2 = this.dpu.cDe;
            if (z2) {
                this.dpu.fp(false);
            } else {
                this.dpu.fq(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
