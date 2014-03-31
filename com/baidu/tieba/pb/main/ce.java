package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ce implements Animation.AnimationListener {
    final /* synthetic */ bk a;
    private final /* synthetic */ com.baidu.tieba.data.an b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(bk bkVar, com.baidu.tieba.data.an anVar, boolean z, String str, String str2) {
        this.a = bkVar;
        this.b = anVar;
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
        new Handler().post(new cf(this, this.b, this.c, this.d, this.e));
    }
}
