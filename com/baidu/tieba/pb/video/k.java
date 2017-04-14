package com.baidu.tieba.pb.video;

import android.view.animation.Animation;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c.InterfaceC0070c {
    final /* synthetic */ d euY;
    private final /* synthetic */ Animation eva;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, Animation animation) {
        this.euY = dVar;
        this.eva = animation;
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0070c
    public void jd(boolean z) {
        boolean aPt;
        com.baidu.tieba.pb.pb.main.view.f fVar;
        com.baidu.tieba.pb.pb.main.view.f fVar2;
        Animation.AnimationListener animationListener;
        com.baidu.tieba.pb.pb.main.view.f fVar3;
        aPt = this.euY.aPt();
        if (aPt) {
            fVar = this.euY.euM;
            if (fVar != null) {
                this.eva.setAnimationListener(null);
                fVar2 = this.euY.euM;
                fVar2.aNX().clearAnimation();
                this.euY.aOd();
                if (z) {
                    Animation animation = this.eva;
                    animationListener = this.euY.duR;
                    animation.setAnimationListener(animationListener);
                    fVar3 = this.euY.euM;
                    fVar3.aNX().startAnimation(this.eva);
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0070c
    public void aPw() {
        boolean aPt;
        aPt = this.euY.aPt();
        if (aPt) {
            this.euY.aOc();
        }
    }
}
