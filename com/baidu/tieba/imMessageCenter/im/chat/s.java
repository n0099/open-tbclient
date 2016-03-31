package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView csx;
    private final /* synthetic */ Animation csy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, Animation animation) {
        this.csx = personalChatView;
        this.csy = animation;
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
        textView = this.csx.cst;
        textView.setVisibility(0);
        textView2 = this.csx.cst;
        textView2.setAnimation(this.csy);
    }
}
