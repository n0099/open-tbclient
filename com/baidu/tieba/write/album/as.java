package com.baidu.tieba.write.album;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements Animation.AnimationListener {
    final /* synthetic */ ac ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ac acVar) {
        this.ggh = acVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        view = this.ggh.gfO;
        view.setAlpha(0.0f);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
