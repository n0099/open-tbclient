package com.baidu.tieba.pb.video;

import android.view.animation.Animation;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements c.InterfaceC0078c {
    final /* synthetic */ l eAW;
    private final /* synthetic */ Animation eAX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(l lVar, Animation animation) {
        this.eAW = lVar;
        this.eAX = animation;
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0078c
    public void jl(boolean z) {
        boolean aOV;
        com.baidu.tieba.pb.pb.main.view.h hVar;
        com.baidu.tieba.pb.pb.main.view.h hVar2;
        Animation.AnimationListener animationListener;
        com.baidu.tieba.pb.pb.main.view.h hVar3;
        aOV = this.eAW.aOV();
        if (aOV) {
            hVar = this.eAW.eAu;
            if (hVar != null) {
                this.eAX.setAnimationListener(null);
                hVar2 = this.eAW.eAu;
                hVar2.aNx().clearAnimation();
                this.eAW.aOT();
                if (z) {
                    Animation animation = this.eAX;
                    animationListener = this.eAW.dwI;
                    animation.setAnimationListener(animationListener);
                    hVar3 = this.eAW.eAu;
                    hVar3.aNx().startAnimation(this.eAX);
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0078c
    public void aPc() {
        boolean aOV;
        aOV = this.eAW.aOV();
        if (aOV) {
            this.eAW.aNC();
        }
    }
}
