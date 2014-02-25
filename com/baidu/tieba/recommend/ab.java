package com.baidu.tieba.recommend;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements Animation.AnimationListener {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.a = zVar;
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
        textView = this.a.i;
        textView.setVisibility(8);
    }
}
