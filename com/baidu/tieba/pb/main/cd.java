package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class cd implements Animation.AnimationListener {
    final /* synthetic */ bj a;
    private final /* synthetic */ com.baidu.tieba.data.ao b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(bj bjVar, com.baidu.tieba.data.ao aoVar, boolean z, String str, String str2) {
        this.a = bjVar;
        this.b = aoVar;
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
        new Handler().post(new ce(this, this.b, this.c, this.d, this.e));
    }
}
