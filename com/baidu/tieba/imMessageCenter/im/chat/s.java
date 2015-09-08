package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bGD;
    private final /* synthetic */ Animation bGE;
    private final /* synthetic */ String bGF;
    private final /* synthetic */ String box;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.bGD = personalChatView;
        this.box = str;
        this.bGF = str2;
        this.bGE = animation;
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
        TextView textView;
        PersonalChatActivity personalChatActivity;
        TextView textView2;
        LinearLayout linearLayout2;
        linearLayout = this.bGD.bGw;
        linearLayout.clearAnimation();
        textView = this.bGD.bGx;
        personalChatActivity = this.bGD.bGu;
        textView.setText(personalChatActivity.getResources().getString(i.h.add_friend_agree_title, this.box));
        textView2 = this.bGD.bGy;
        textView2.setText(this.bGF);
        linearLayout2 = this.bGD.bGw;
        linearLayout2.setAnimation(this.bGE);
    }
}
