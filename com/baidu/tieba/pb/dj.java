package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dj implements Animation.AnimationListener {
    final /* synthetic */ cu a;
    private final /* synthetic */ ImageView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(cu cuVar, ImageView imageView) {
        this.a = cuVar;
        this.b = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        new Handler().post(new dk(this, this.b));
    }
}
