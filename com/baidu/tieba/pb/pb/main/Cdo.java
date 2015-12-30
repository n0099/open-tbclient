package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.tieba.pb.pb.main.do  reason: invalid class name */
/* loaded from: classes.dex */
public class Cdo implements Animation.AnimationListener {
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(dk dkVar) {
        this.cKg = dkVar;
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
        z = this.cKg.cJw;
        if (!z) {
            kVar = this.cKg.Li;
            if (kVar != null) {
                kVar2 = this.cKg.Li;
                kVar2.ob();
                return;
            }
            return;
        }
        view = this.cKg.cJs;
        if (view != null) {
            z2 = this.cKg.cJq;
            if (z2) {
                this.cKg.fk(false);
            } else {
                this.cKg.fl(false);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
