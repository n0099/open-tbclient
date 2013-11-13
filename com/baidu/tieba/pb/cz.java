package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cz implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageView f2131a;
    final /* synthetic */ cp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(cp cpVar, ImageView imageView) {
        this.b = cpVar;
        this.f2131a = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new da(this));
    }
}
