package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements Animation.AnimationListener {
    final /* synthetic */ cc cly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(cc ccVar) {
        this.cly = ccVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        com.baidu.tbadk.editortools.j jVar;
        com.baidu.tbadk.editortools.j jVar2;
        View view;
        boolean z2;
        z = this.cly.clh;
        if (!z) {
            jVar = this.cly.Kz;
            if (jVar != null) {
                jVar2 = this.cly.Kz;
                jVar2.ow();
                return;
            }
            return;
        }
        view = this.cly.cld;
        if (view != null) {
            z2 = this.cly.clb;
            if (z2) {
                this.cly.eE(false);
            } else {
                this.cly.eF(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
