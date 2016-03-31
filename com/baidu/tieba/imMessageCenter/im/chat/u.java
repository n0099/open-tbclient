package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView csx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PersonalChatView personalChatView) {
        this.csx = personalChatView;
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
        linearLayout = this.csx.csp;
        linearLayout.setVisibility(8);
    }
}
