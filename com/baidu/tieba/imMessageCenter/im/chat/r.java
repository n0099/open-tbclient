package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bJT;
    private final /* synthetic */ Animation bJU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PersonalChatView personalChatView, Animation animation) {
        this.bJT = personalChatView;
        this.bJU = animation;
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
        TextView textView2;
        textView = this.bJT.bJP;
        textView.setVisibility(0);
        textView2 = this.bJT.bJP;
        textView2.setAnimation(this.bJU);
    }
}
