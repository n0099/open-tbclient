package com.baidu.tieba.pb.video;

import android.view.animation.Animation;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements c.InterfaceC0081c {
    final /* synthetic */ l eKu;
    private final /* synthetic */ Animation eKv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(l lVar, Animation animation) {
        this.eKu = lVar;
        this.eKv = animation;
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0081c
    public void jJ(boolean z) {
        boolean aSU;
        com.baidu.tieba.pb.pb.main.view.j jVar;
        com.baidu.tieba.pb.pb.main.view.j jVar2;
        Animation.AnimationListener animationListener;
        com.baidu.tieba.pb.pb.main.view.j jVar3;
        aSU = this.eKu.aSU();
        if (aSU) {
            jVar = this.eKu.eJS;
            if (jVar != null) {
                this.eKv.setAnimationListener(null);
                jVar2 = this.eKu.eJS;
                jVar2.aRx().clearAnimation();
                this.eKu.aSS();
                if (z) {
                    Animation animation = this.eKv;
                    animationListener = this.eKu.dFv;
                    animation.setAnimationListener(animationListener);
                    jVar3 = this.eKu.eJS;
                    jVar3.aRx().startAnimation(this.eKv);
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0081c
    public void aTb() {
        boolean aSU;
        aSU = this.eKu.aSU();
        if (aSU) {
            this.eKu.aRC();
        }
    }
}
