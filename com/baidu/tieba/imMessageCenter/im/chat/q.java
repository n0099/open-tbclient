package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bGD;
    private final /* synthetic */ Animation bGE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalChatView personalChatView, Animation animation) {
        this.bGD = personalChatView;
        this.bGE = animation;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView;
        textView = this.bGD.bGz;
        textView.startAnimation(this.bGE);
    }
}
