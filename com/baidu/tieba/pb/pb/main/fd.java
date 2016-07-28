package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fd implements Animation.AnimationListener {
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fd(ew ewVar) {
        this.eiu = ewVar;
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
        z = this.eiu.eht;
        if (!z) {
            lVar = this.eiu.Cw;
            if (lVar != null) {
                lVar2 = this.eiu.Cw;
                lVar2.kB();
                return;
            }
            return;
        }
        view = this.eiu.eho;
        if (view != null) {
            z2 = this.eiu.dlB;
            if (z2 && !this.eiu.aLj()) {
                this.eiu.gg(false);
            } else {
                this.eiu.gh(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
