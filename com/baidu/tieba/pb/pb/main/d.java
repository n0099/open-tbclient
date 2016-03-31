package com.baidu.tieba.pb.pb.main;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class d implements Animation.AnimationListener {
    final /* synthetic */ GetLotteryChanceActivity dfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GetLotteryChanceActivity getLotteryChanceActivity) {
        this.dfT = getLotteryChanceActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.dfT.finish();
    }
}
