package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class cm implements Animation.AnimationListener {
    final /* synthetic */ bz bEB;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.o bEE;
    private final /* synthetic */ boolean bEF;
    private final /* synthetic */ String bEG;
    private final /* synthetic */ String bEH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(bz bzVar, com.baidu.tieba.tbadkCore.b.o oVar, boolean z, String str, String str2) {
        this.bEB = bzVar;
        this.bEE = oVar;
        this.bEF = z;
        this.bEG = str;
        this.bEH = str2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new cn(this, this.bEE, this.bEF, this.bEG, this.bEH));
    }
}
