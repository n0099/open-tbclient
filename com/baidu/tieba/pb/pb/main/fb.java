package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fb implements Animation.AnimationListener {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(eu euVar) {
        this.dnc = euVar;
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
        z = this.dnc.dmb;
        if (!z) {
            lVar = this.dnc.LE;
            if (lVar != null) {
                lVar2 = this.dnc.LE;
                lVar2.op();
                return;
            }
            return;
        }
        view = this.dnc.dlV;
        if (view != null) {
            z2 = this.dnc.cCe;
            if (z2) {
                this.dnc.eN(false);
            } else {
                this.dnc.eO(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
