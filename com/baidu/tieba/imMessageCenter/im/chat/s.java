package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView cYK;
    private final /* synthetic */ Animation cYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, Animation animation) {
        this.cYK = personalChatView;
        this.cYL = animation;
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
        textView = this.cYK.cYG;
        textView.setVisibility(0);
        textView2 = this.cYK.cYG;
        textView2.setAnimation(this.cYL);
    }
}
