package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class gb implements Animation.AnimationListener {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gb(fa faVar) {
        this.etn = faVar;
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
        this.etn.esO = false;
        textView = this.etn.esM;
        textView.setVisibility(8);
    }
}
