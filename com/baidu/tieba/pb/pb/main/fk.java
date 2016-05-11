package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fk implements Animation.AnimationListener {
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(el elVar) {
        this.dpu = elVar;
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
        this.dpu.doZ = false;
        textView = this.dpu.doX;
        textView.setVisibility(8);
    }
}
