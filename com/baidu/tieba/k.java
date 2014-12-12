package com.baidu.tieba;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class k implements Animation.AnimationListener {
    final /* synthetic */ LogoActivity akC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LogoActivity logoActivity) {
        this.akC = logoActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        boolean z;
        this.akC.akt = true;
        z = this.akC.aku;
        if (!z) {
            return;
        }
        this.akC.ai(this.akC.getBaseContext());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
