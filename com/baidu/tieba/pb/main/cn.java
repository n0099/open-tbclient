package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class cn implements Animation.AnimationListener {
    final /* synthetic */ bz bCR;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.o bCV;
    private final /* synthetic */ boolean bCW;
    private final /* synthetic */ String bCX;
    private final /* synthetic */ String bCY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(bz bzVar, com.baidu.tieba.tbadkCore.b.o oVar, boolean z, String str, String str2) {
        this.bCR = bzVar;
        this.bCV = oVar;
        this.bCW = z;
        this.bCX = str;
        this.bCY = str2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new co(this, this.bCV, this.bCW, this.bCX, this.bCY));
    }
}
