package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bsg;
    private final /* synthetic */ Animation bsh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, Animation animation) {
        this.bsg = personalChatView;
        this.bsh = animation;
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
        textView = this.bsg.bsd;
        textView.startAnimation(this.bsh);
    }
}
