package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class ck implements Animation.AnimationListener {
    final /* synthetic */ bt a;
    private final /* synthetic */ com.baidu.tieba.data.at b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(bt btVar, com.baidu.tieba.data.at atVar, boolean z, String str, String str2) {
        this.a = btVar;
        this.b = atVar;
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
        new Handler().post(new cl(this, this.b, this.c, this.d, this.e));
    }
}
