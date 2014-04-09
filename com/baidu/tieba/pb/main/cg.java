package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cg implements Animation.AnimationListener {
    final /* synthetic */ bm a;
    private final /* synthetic */ com.baidu.tieba.data.am b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(bm bmVar, com.baidu.tieba.data.am amVar, boolean z, String str, String str2) {
        this.a = bmVar;
        this.b = amVar;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        new Handler().post(new ch(this, this.b, this.c, this.d, this.e));
    }
}
