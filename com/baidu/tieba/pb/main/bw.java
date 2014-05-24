package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements Animation.AnimationListener {
    final /* synthetic */ bq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(bq bqVar) {
        this.a = bqVar;
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
        bq bqVar = this.a;
        view = this.a.aL;
        bqVar.aR = view.getVisibility() == 0;
        this.a.j.setVisibility(8);
        view2 = this.a.aL;
        view2.setVisibility(8);
        view3 = this.a.aK;
        view3.setVisibility(8);
        pbActivity = this.a.m;
        pbActivity.showToast(com.baidu.tieba.y.pb_double_click_tips, 0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
