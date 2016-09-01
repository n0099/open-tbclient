package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fw implements Animation.AnimationListener {
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(ex exVar) {
        this.euB = exVar;
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
        this.euB.eug = false;
        textView = this.euB.eue;
        textView.setVisibility(8);
    }
}
