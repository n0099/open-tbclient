package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Animation.AnimationListener {
    private final /* synthetic */ String bac;
    final /* synthetic */ PersonalChatView bsg;
    private final /* synthetic */ Animation bsh;
    private final /* synthetic */ String bsi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.bsg = personalChatView;
        this.bac = str;
        this.bsi = str2;
        this.bsh = animation;
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
        linearLayout = this.bsg.bsa;
        linearLayout.clearAnimation();
        textView = this.bsg.bsb;
        personalChatActivity = this.bsg.brY;
        textView.setText(personalChatActivity.getResources().getString(com.baidu.tieba.t.add_friend_agree_title, this.bac));
        textView2 = this.bsg.bsc;
        textView2.setText(this.bsi);
        linearLayout2 = this.bsg.bsa;
        linearLayout2.setAnimation(this.bsh);
    }
}
