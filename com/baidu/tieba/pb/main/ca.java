package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.editortool.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements Animation.AnimationListener {
    final /* synthetic */ bv byI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bv bvVar) {
        this.byI = bvVar;
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
        View view2;
        z = this.byI.byw;
        if (!z) {
            pbEditor = this.byI.byn;
            if (pbEditor != null) {
                pbEditor2 = this.byI.byn;
                pbEditor2.setVisibility(0);
                return;
            }
            return;
        }
        view = this.byI.byq;
        view.setVisibility(0);
        view2 = this.byI.byp;
        view2.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
