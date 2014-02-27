package com.baidu.tieba.recommend;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab implements Animation.AnimationListener {
    final /* synthetic */ z a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.a = zVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        TextView textView;
        textView = this.a.i;
        textView.setVisibility(8);
    }
}
