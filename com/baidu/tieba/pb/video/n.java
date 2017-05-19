package com.baidu.tieba.pb.video;

import android.view.animation.Animation;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements c.InterfaceC0076c {
    final /* synthetic */ g esY;
    private final /* synthetic */ Animation eta;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(g gVar, Animation animation) {
        this.esY = gVar;
        this.eta = animation;
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0076c
    public void iS(boolean z) {
        boolean aNL;
        com.baidu.tieba.pb.pb.main.view.f fVar;
        com.baidu.tieba.pb.pb.main.view.f fVar2;
        Animation.AnimationListener animationListener;
        com.baidu.tieba.pb.pb.main.view.f fVar3;
        aNL = this.esY.aNL();
        if (aNL) {
            fVar = this.esY.esM;
            if (fVar != null) {
                this.eta.setAnimationListener(null);
                fVar2 = this.esY.esM;
                fVar2.aMn().clearAnimation();
                this.esY.aMt();
                if (z) {
                    Animation animation = this.eta;
                    animationListener = this.esY.drq;
                    animation.setAnimationListener(animationListener);
                    fVar3 = this.esY.esM;
                    fVar3.aMn().startAnimation(this.eta);
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0076c
    public void aNO() {
        boolean aNL;
        aNL = this.esY.aNL();
        if (aNL) {
            this.esY.aMs();
        }
    }
}
