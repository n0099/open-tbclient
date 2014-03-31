package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bq implements Animation.AnimationListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        View view3;
        PbActivity pbActivity;
        bk bkVar = this.a;
        view = this.a.aJ;
        bkVar.aP = view.getVisibility() == 0;
        this.a.j.setVisibility(8);
        view2 = this.a.aJ;
        view2.setVisibility(8);
        view3 = this.a.aI;
        view3.setVisibility(8);
        pbActivity = this.a.m;
        pbActivity.showToast(com.baidu.tieba.a.k.pb_double_click_tips, 0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }
}
