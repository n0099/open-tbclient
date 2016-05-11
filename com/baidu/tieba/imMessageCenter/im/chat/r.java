package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView ctu;
    private final /* synthetic */ Animation ctv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PersonalChatView personalChatView, Animation animation) {
        this.ctu = personalChatView;
        this.ctv = animation;
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
        textView = this.ctu.ctq;
        textView.startAnimation(this.ctv);
    }
}
