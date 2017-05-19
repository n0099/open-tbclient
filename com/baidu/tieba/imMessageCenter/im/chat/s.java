package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView ddP;
    private final /* synthetic */ Animation ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, Animation animation) {
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
        TextView textView2;
        textView = this.ddP.ddL;
        textView.setVisibility(0);
        textView2 = this.ddP.ddL;
        textView2.setAnimation(this.ddQ);
    }
}
