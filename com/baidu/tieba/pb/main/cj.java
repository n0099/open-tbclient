package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class cj implements Animation.AnimationListener {
    final /* synthetic */ bv byI;
    private final /* synthetic */ com.baidu.tieba.data.ar byL;
    private final /* synthetic */ boolean byM;
    private final /* synthetic */ String byN;
    private final /* synthetic */ String byO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(bv bvVar, com.baidu.tieba.data.ar arVar, boolean z, String str, String str2) {
        this.byI = bvVar;
        this.byL = arVar;
        this.byM = z;
        this.byN = str;
        this.byO = str2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new ck(this, this.byL, this.byM, this.byN, this.byO));
    }
}
