package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class cg implements Animation.AnimationListener {
    final /* synthetic */ bs a;
    private final /* synthetic */ com.baidu.tieba.data.au b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(bs bsVar, com.baidu.tieba.data.au auVar, boolean z, String str, String str2) {
        this.a = bsVar;
        this.b = auVar;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new ch(this, this.b, this.c, this.d, this.e));
    }
}
