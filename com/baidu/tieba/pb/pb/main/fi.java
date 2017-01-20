package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fi implements Animation.AnimationListener {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi(ez ezVar) {
        this.eqf = ezVar;
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
        z = this.eqf.epg;
        if (!z) {
            jVar = this.eqf.DX;
            if (jVar != null) {
                jVar2 = this.eqf.DX;
                jVar2.lr();
                return;
            }
            return;
        }
        view = this.eqf.epb;
        if (view != null) {
            z2 = this.eqf.doq;
            if (z2) {
                this.eqf.gM(false);
            } else {
                this.eqf.gN(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
