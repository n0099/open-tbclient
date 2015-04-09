package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Animation.AnimationListener {
    private final /* synthetic */ String aXw;
    final /* synthetic */ PersonalChatView bpA;
    private final /* synthetic */ Animation bpB;
    private final /* synthetic */ String bpC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.bpA = personalChatView;
        this.aXw = str;
        this.bpC = str2;
        this.bpB = animation;
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
        linearLayout = this.bpA.bpu;
        linearLayout.clearAnimation();
        textView = this.bpA.bpv;
        personalChatActivity = this.bpA.bps;
        textView.setText(personalChatActivity.getResources().getString(y.add_friend_agree_title, this.aXw));
        textView2 = this.bpA.bpw;
        textView2.setText(this.bpC);
        linearLayout2 = this.bpA.bpu;
        linearLayout2.setAnimation(this.bpB);
    }
}
