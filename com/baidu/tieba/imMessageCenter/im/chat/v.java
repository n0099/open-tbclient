package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Animation.AnimationListener {
    private final /* synthetic */ String bad;
    final /* synthetic */ PersonalChatView bsh;
    private final /* synthetic */ Animation bsi;
    private final /* synthetic */ String bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.bsh = personalChatView;
        this.bad = str;
        this.bsj = str2;
        this.bsi = animation;
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
        linearLayout = this.bsh.bsb;
        linearLayout.clearAnimation();
        textView = this.bsh.bsc;
        personalChatActivity = this.bsh.brZ;
        textView.setText(personalChatActivity.getResources().getString(com.baidu.tieba.t.add_friend_agree_title, this.bad));
        textView2 = this.bsh.bsd;
        textView2.setText(this.bsj);
        linearLayout2 = this.bsh.bsb;
        linearLayout2.setAnimation(this.bsi);
    }
}
