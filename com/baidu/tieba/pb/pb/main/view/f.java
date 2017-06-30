package com.baidu.tieba.pb.pb.main.view;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ PbFloorAgreeView eGD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbFloorAgreeView pbFloorAgreeView) {
        this.eGD = pbFloorAgreeView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView;
        textView = this.eGD.eGA;
        textView.setVisibility(8);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
