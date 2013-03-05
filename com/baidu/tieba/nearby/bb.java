package com.baidu.tieba.nearby;

import android.view.animation.Animation;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements Animation.AnimationListener {
    final /* synthetic */ NewNearbyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(NewNearbyActivity newNearbyActivity) {
        this.a = newNearbyActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ImageView imageView;
        ImageView imageView2;
        imageView = this.a.A;
        imageView.setVisibility(4);
        imageView2 = this.a.B;
        imageView2.setVisibility(4);
    }
}
