package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ft implements Animation.AnimationListener {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft(eu euVar) {
        this.dnc = euVar;
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
        this.dnc.dmH = false;
        textView = this.dnc.dmF;
        textView.setVisibility(8);
    }
}
