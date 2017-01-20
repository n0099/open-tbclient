package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
import com.baidu.tieba.play.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fc implements c.InterfaceC0072c {
    final /* synthetic */ ez eqf;
    private final /* synthetic */ Animation eqg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fc(ez ezVar, Animation animation) {
        this.eqf = ezVar;
        this.eqg = animation;
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0072c
    public void iZ(boolean z) {
        Animation.AnimationListener animationListener;
        if (this.eqf.enK != null) {
            this.eqg.setAnimationListener(null);
            this.eqf.enK.aOw().clearAnimation();
            this.eqf.enK.aOD();
            if (z) {
                Animation animation = this.eqg;
                animationListener = this.eqf.dvW;
                animation.setAnimationListener(animationListener);
                this.eqf.enK.aOw().startAnimation(this.eqg);
            }
        }
    }

    @Override // com.baidu.tieba.play.c.InterfaceC0072c
    public void aOr() {
        if (this.eqf.enK != null) {
            this.eqf.enK.aOC();
        }
    }
}
