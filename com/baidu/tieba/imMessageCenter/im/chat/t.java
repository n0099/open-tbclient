package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bpk;
    private final /* synthetic */ Animation bpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, Animation animation) {
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
        textView = this.bpk.bph;
        textView.startAnimation(this.bpl);
    }
}
