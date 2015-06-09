package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bsh;
    private final /* synthetic */ Animation bsi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, Animation animation) {
        this.bsh = personalChatView;
        this.bsi = animation;
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
        textView = this.bsh.bse;
        textView.startAnimation(this.bsi);
    }
}
