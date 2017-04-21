package com.baidu.tieba.pb.video;

import android.view.animation.Animation;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c.InterfaceC0070c {
    final /* synthetic */ d exo;
    private final /* synthetic */ Animation exq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, Animation animation) {
        this.exo = dVar;
        this.exq = animation;
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0070c
    public void jn(boolean z) {
        boolean aQu;
        com.baidu.tieba.pb.pb.main.view.f fVar;
        com.baidu.tieba.pb.pb.main.view.f fVar2;
        Animation.AnimationListener animationListener;
        com.baidu.tieba.pb.pb.main.view.f fVar3;
        aQu = this.exo.aQu();
        if (aQu) {
            fVar = this.exo.exc;
            if (fVar != null) {
                this.exq.setAnimationListener(null);
                fVar2 = this.exo.exc;
                fVar2.aOY().clearAnimation();
                this.exo.aPe();
                if (z) {
                    Animation animation = this.exq;
                    animationListener = this.exo.dxh;
                    animation.setAnimationListener(animationListener);
                    fVar3 = this.exo.exc;
                    fVar3.aOY().startAnimation(this.exq);
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0070c
    public void aQx() {
        boolean aQu;
        aQu = this.exo.aQu();
        if (aQu) {
            this.exo.aPd();
        }
    }
}
