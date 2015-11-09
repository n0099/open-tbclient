package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bKo;
    private final /* synthetic */ Animation bKp;
    private final /* synthetic */ String bKq;
    private final /* synthetic */ String bsl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.bKo = personalChatView;
        this.bsl = str;
        this.bKq = str2;
        this.bKp = animation;
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
        linearLayout = this.bKo.bKh;
        linearLayout.clearAnimation();
        textView = this.bKo.bKi;
        personalChatActivity = this.bKo.bKf;
        textView.setText(personalChatActivity.getResources().getString(i.h.add_friend_agree_title, this.bsl));
        textView2 = this.bKo.bKj;
        textView2.setText(this.bKq);
        linearLayout2 = this.bKo.bKh;
        linearLayout2.setAnimation(this.bKp);
    }
}
