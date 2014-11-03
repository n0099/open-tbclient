package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.editortool.PbEditor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements Animation.AnimationListener {
    final /* synthetic */ bv byW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bv bvVar) {
        this.byW = bvVar;
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
        bv bvVar = this.byW;
        view = this.byW.byE;
        bvVar.byK = view.getVisibility() == 0;
        pbEditor = this.byW.byB;
        if (pbEditor != null) {
            pbEditor2 = this.byW.byB;
            pbEditor2.setVisibility(8);
        }
        view2 = this.byW.byE;
        view2.setVisibility(8);
        view3 = this.byW.byD;
        view3.setVisibility(8);
        pbActivity = this.byW.bxe;
        pbActivity.showToast(com.baidu.tieba.y.pb_double_click_tips, 0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
