package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView diX;
    private final /* synthetic */ Animation diY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PersonalChatView personalChatView, Animation animation) {
        this.diX = personalChatView;
        this.diY = animation;
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
        textView = this.diX.diT;
        textView.startAnimation(this.diY);
    }
}
