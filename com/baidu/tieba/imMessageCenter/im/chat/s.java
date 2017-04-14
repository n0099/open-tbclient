package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView dhw;
    private final /* synthetic */ Animation dhx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, Animation animation) {
        this.dhw = personalChatView;
        this.dhx = animation;
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
        textView = this.dhw.dhs;
        textView.setVisibility(0);
        textView2 = this.dhw.dhs;
        textView2.setAnimation(this.dhx);
    }
}
