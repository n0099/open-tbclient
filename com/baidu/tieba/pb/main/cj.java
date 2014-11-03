package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class cj implements Animation.AnimationListener {
    final /* synthetic */ bv byW;
    private final /* synthetic */ com.baidu.tieba.data.ar byZ;
    private final /* synthetic */ boolean bza;
    private final /* synthetic */ String bzb;
    private final /* synthetic */ String bzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(bv bvVar, com.baidu.tieba.data.ar arVar, boolean z, String str, String str2) {
        this.byW = bvVar;
        this.byZ = arVar;
        this.bza = z;
        this.bzb = str;
        this.bzc = str2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new ck(this, this.byZ, this.bza, this.bzb, this.bzc));
    }
}
