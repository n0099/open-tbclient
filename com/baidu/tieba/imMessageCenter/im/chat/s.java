package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView chS;
    private final /* synthetic */ Animation chT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, Animation animation) {
        this.chS = personalChatView;
        this.chT = animation;
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
        textView = this.chS.chO;
        textView.setVisibility(0);
        textView2 = this.chS.chO;
        textView2.setAnimation(this.chT);
    }
}
