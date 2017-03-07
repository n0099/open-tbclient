package com.baidu.tieba.pb.video;

import android.view.animation.Animation;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c.InterfaceC0071c {
    final /* synthetic */ d ewS;
    private final /* synthetic */ Animation ewU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar, Animation animation) {
        this.ewS = dVar;
        this.ewU = animation;
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0071c
    public void je(boolean z) {
        boolean aPk;
        com.baidu.tieba.pb.pb.main.view.f fVar;
        com.baidu.tieba.pb.pb.main.view.f fVar2;
        Animation.AnimationListener animationListener;
        com.baidu.tieba.pb.pb.main.view.f fVar3;
        aPk = this.ewS.aPk();
        if (aPk) {
            fVar = this.ewS.ewH;
            if (fVar != null) {
                this.ewU.setAnimationListener(null);
                fVar2 = this.ewS.ewH;
                fVar2.aNO().clearAnimation();
                this.ewS.aNU();
                if (z) {
                    Animation animation = this.ewU;
                    animationListener = this.ewS.dyu;
                    animation.setAnimationListener(animationListener);
                    fVar3 = this.ewS.ewH;
                    fVar3.aNO().startAnimation(this.ewU);
                }
            }
        }
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0071c
    public void aPn() {
        boolean aPk;
        aPk = this.ewS.aPk();
        if (aPk) {
            this.ewS.aNT();
        }
    }
}
