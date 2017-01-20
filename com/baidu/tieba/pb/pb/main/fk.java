package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class fk implements Animation.AnimationListener {
    final /* synthetic */ ez eqf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(ez ezVar) {
        this.eqf = ezVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.eqf.enK != null) {
            this.eqf.enK.aOC();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
