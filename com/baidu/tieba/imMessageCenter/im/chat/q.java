package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bKo;
    private final /* synthetic */ Animation bKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalChatView personalChatView, Animation animation) {
        this.bKo = personalChatView;
        this.bKp = animation;
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
        textView = this.bKo.bKk;
        textView.startAnimation(this.bKp);
    }
}
