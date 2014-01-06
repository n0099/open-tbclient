package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db implements Animation.AnimationListener {
    final /* synthetic */ ImageView a;
    final /* synthetic */ cs b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(cs csVar, ImageView imageView) {
        this.b = csVar;
        this.a = imageView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new dc(this));
    }
}
