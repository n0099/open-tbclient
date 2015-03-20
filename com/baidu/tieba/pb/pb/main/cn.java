package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements Animation.AnimationListener {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        PbEditor pbEditor;
        PbEditor pbEditor2;
        View view;
        z = this.bMm.bLW;
        if (!z) {
            pbEditor = this.bMm.bLR;
            if (pbEditor != null) {
                pbEditor2 = this.bMm.bLR;
                pbEditor2.setVisibility(0);
                return;
            }
            return;
        }
        view = this.bMm.bLT;
        view.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
