package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements Animation.AnimationListener {
    final /* synthetic */ cj bMC;
    private final /* synthetic */ com.baidu.tieba.pb.a.c bME;
    private final /* synthetic */ boolean bMF;
    private final /* synthetic */ String bMG;
    private final /* synthetic */ String bMH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cj cjVar, com.baidu.tieba.pb.a.c cVar, boolean z, String str, String str2) {
        this.bMC = cjVar;
        this.bME = cVar;
        this.bMF = z;
        this.bMG = str;
        this.bMH = str2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        dh dhVar;
        com.baidu.tieba.pb.pb.sub.l lVar;
        dh dhVar2;
        dhVar = this.bMC.bMa;
        if (dhVar != null) {
            dhVar2 = this.bMC.bMa;
            dhVar2.a(this.bME);
        }
        if (this.bMF) {
            lVar = this.bMC.bLz;
            lVar.aQ(this.bMG, this.bMH);
        }
    }
}
