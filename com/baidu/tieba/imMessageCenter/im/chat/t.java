package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bKo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView) {
        this.bKo = personalChatView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        LinearLayout linearLayout;
        linearLayout = this.bKo.bKg;
        linearLayout.setVisibility(8);
    }
}
