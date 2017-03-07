package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class fl implements Animation.AnimationListener {
    final /* synthetic */ fa etn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fl(fa faVar) {
        this.etn = faVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.etn.eqM != null) {
            this.etn.eqM.aNT();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
