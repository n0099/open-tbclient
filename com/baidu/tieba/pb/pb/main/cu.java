package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cu implements Animation.AnimationListener {
    final /* synthetic */ ci bMm;
    private final /* synthetic */ com.baidu.tieba.pb.a.c bMo;
    private final /* synthetic */ boolean bMp;
    private final /* synthetic */ String bMq;
    private final /* synthetic */ String bMr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(ci ciVar, com.baidu.tieba.pb.a.c cVar, boolean z, String str, String str2) {
        this.bMm = ciVar;
        this.bMo = cVar;
        this.bMp = z;
        this.bMq = str;
        this.bMr = str2;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        dg dgVar;
        com.baidu.tieba.pb.pb.sub.l lVar;
        dg dgVar2;
        dgVar = this.bMm.bLK;
        if (dgVar != null) {
            dgVar2 = this.bMm.bLK;
            dgVar2.a(this.bMo);
        }
        if (this.bMp) {
            lVar = this.bMm.bLk;
            lVar.aQ(this.bMq, this.bMr);
        }
    }
}
