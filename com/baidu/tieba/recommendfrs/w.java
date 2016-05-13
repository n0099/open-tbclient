package com.baidu.tieba.recommendfrs;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Animation.AnimationListener {
    final /* synthetic */ r dYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(r rVar) {
        this.dYM = rVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView;
        textView = this.dYM.SF;
        if (textView == null) {
            return;
        }
        this.dYM.aMh();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
