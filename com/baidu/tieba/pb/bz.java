package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class bz implements Animation.AnimationListener {
    final /* synthetic */ bk a;
    private final /* synthetic */ com.baidu.tieba.a.ay b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bk bkVar, com.baidu.tieba.a.ay ayVar, boolean z, String str) {
        this.a = bkVar;
        this.b = ayVar;
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
        new Handler().post(new ca(this, this.b, this.c, this.d));
    }
}
