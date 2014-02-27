package com.baidu.tieba.pb;

import android.view.animation.Animation;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cw implements Animation.AnimationListener {
    final /* synthetic */ cu a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cu cuVar) {
        this.a = cuVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        RelativeLayout relativeLayout;
        relativeLayout = this.a.n;
        relativeLayout.setVisibility(4);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }
}
