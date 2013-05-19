package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class bx implements Animation.AnimationListener {
    final /* synthetic */ bl a;
    private final /* synthetic */ com.baidu.tieba.a.ax b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(bl blVar, com.baidu.tieba.a.ax axVar, boolean z, String str) {
        this.a = blVar;
        this.b = axVar;
        this.c = z;
        this.d = str;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new by(this, this.b, this.c, this.d));
    }
}
