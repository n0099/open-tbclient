package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bsh;
    private final /* synthetic */ Animation bsi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PersonalChatView personalChatView, Animation animation) {
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
        TextView textView2;
        textView = this.bsh.bse;
        textView.setVisibility(0);
        textView2 = this.bsh.bse;
        textView2.setAnimation(this.bsi);
    }
}
