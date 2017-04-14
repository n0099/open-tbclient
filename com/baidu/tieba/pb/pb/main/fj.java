package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class fj implements Animation.AnimationListener {
    final /* synthetic */ ey erv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fj(ey eyVar) {
        this.erv = eyVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.erv.eoV != null) {
            this.erv.eoV.aOc();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
