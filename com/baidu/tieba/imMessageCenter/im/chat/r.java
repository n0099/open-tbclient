package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class r implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView ddP;
    private final /* synthetic */ Animation ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PersonalChatView personalChatView, Animation animation) {
        this.ddP = personalChatView;
        this.ddQ = animation;
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
        textView = this.ddP.ddL;
        textView.startAnimation(this.ddQ);
    }
}
