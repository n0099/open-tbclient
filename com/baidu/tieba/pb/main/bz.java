package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.editortool.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements Animation.AnimationListener {
    final /* synthetic */ bv byI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bv bvVar) {
        this.byI = bvVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        PbEditor pbEditor;
        View view2;
        View view3;
        PbActivity pbActivity;
        PbEditor pbEditor2;
        bv bvVar = this.byI;
        view = this.byI.byq;
        bvVar.byw = view.getVisibility() == 0;
        pbEditor = this.byI.byn;
        if (pbEditor != null) {
            pbEditor2 = this.byI.byn;
            pbEditor2.setVisibility(8);
        }
        view2 = this.byI.byq;
        view2.setVisibility(8);
        view3 = this.byI.byp;
        view3.setVisibility(8);
        pbActivity = this.byI.bwQ;
        pbActivity.showToast(com.baidu.tieba.y.pb_double_click_tips, 0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
