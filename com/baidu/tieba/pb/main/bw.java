package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Animation.AnimationListener {
    final /* synthetic */ bt a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bt btVar) {
        this.a = btVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        View view3;
        PbActivity pbActivity;
        bt btVar = this.a;
        view = this.a.aJ;
        btVar.aP = view.getVisibility() == 0;
        this.a.h.setVisibility(8);
        view2 = this.a.aJ;
        view2.setVisibility(8);
        view3 = this.a.aI;
        view3.setVisibility(8);
        pbActivity = this.a.k;
        pbActivity.showToast(com.baidu.tieba.y.pb_double_click_tips, 0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
