package com.baidu.tieba.nearby;

import android.view.animation.Animation;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewNearbyActivity f1154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(NewNearbyActivity newNearbyActivity) {
        this.f1154a = newNearbyActivity;
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
        imageView = this.f1154a.E;
        imageView.setVisibility(4);
        imageView2 = this.f1154a.F;
        imageView2.setVisibility(4);
    }
}
