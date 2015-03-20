package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bpk;
    private final /* synthetic */ Animation bpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PersonalChatView personalChatView, Animation animation) {
        this.bpk = personalChatView;
        this.bpl = animation;
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
        textView = this.bpk.bph;
        textView.setVisibility(0);
        textView2 = this.bpk.bph;
        textView2.setAnimation(this.bpl);
    }
}
