package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bFW;
    private final /* synthetic */ Animation bFX;
    private final /* synthetic */ String bFY;
    private final /* synthetic */ String bnZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.bFW = personalChatView;
        this.bnZ = str;
        this.bFY = str2;
        this.bFX = animation;
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
        linearLayout = this.bFW.bFP;
        linearLayout.clearAnimation();
        textView = this.bFW.bFQ;
        personalChatActivity = this.bFW.bFN;
        textView.setText(personalChatActivity.getResources().getString(i.C0057i.add_friend_agree_title, this.bnZ));
        textView2 = this.bFW.bFR;
        textView2.setText(this.bFY);
        linearLayout2 = this.bFW.bFP;
        linearLayout2.setAnimation(this.bFX);
    }
}
