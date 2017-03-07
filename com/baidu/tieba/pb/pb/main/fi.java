package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fi implements Animation.AnimationListener {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fi(fa faVar) {
        this.etn = faVar;
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
        z = this.etn.esk;
        if (!z) {
            jVar = this.etn.Ll;
            if (jVar != null) {
                jVar2 = this.etn.Ll;
                jVar2.ml();
                return;
            }
            return;
        }
        view = this.etn.esf;
        if (view != null) {
            z2 = this.etn.dqK;
            if (z2) {
                this.etn.gD(false);
            } else {
                this.etn.gE(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
