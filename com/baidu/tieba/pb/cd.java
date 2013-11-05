package com.baidu.tieba.pb;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class cd implements Animation.AnimationListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.bb f2091a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ bt d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bt btVar, com.baidu.tieba.data.bb bbVar, boolean z, String str) {
        this.d = btVar;
        this.f2091a = bbVar;
        this.b = z;
        this.c = str;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new ce(this));
    }
}
