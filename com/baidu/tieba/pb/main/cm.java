package com.baidu.tieba.pb.main;

import android.os.Handler;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class cm implements Animation.AnimationListener {
    final /* synthetic */ bz bEC;
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.o bEF;
    private final /* synthetic */ boolean bEG;
    private final /* synthetic */ String bEH;
    private final /* synthetic */ String bEI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(bz bzVar, com.baidu.tieba.tbadkCore.b.o oVar, boolean z, String str, String str2) {
        this.bEC = bzVar;
        this.bEF = oVar;
        this.bEG = z;
        this.bEH = str;
        this.bEI = str2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        new Handler().post(new cn(this, this.bEF, this.bEG, this.bEH, this.bEI));
    }
}
