package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.editortool.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements Animation.AnimationListener {
    final /* synthetic */ bv byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bv bvVar) {
        this.byW = bvVar;
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
        z = this.byW.byK;
        if (!z) {
            pbEditor = this.byW.byB;
            if (pbEditor != null) {
                pbEditor2 = this.byW.byB;
                pbEditor2.setVisibility(0);
                return;
            }
            return;
        }
        view = this.byW.byE;
        view.setVisibility(0);
        view2 = this.byW.byD;
        view2.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
