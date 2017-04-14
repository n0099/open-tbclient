package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fz implements Animation.AnimationListener {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fz(ey eyVar) {
        this.erv = eyVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView;
        this.erv.eqX = false;
        textView = this.erv.eqV;
        textView.setVisibility(8);
    }
}
