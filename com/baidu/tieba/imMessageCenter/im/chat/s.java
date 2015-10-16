package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bJT;
    private final /* synthetic */ Animation bJU;
    private final /* synthetic */ String bJV;
    private final /* synthetic */ String brH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.bJT = personalChatView;
        this.brH = str;
        this.bJV = str2;
        this.bJU = animation;
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
        linearLayout = this.bJT.bJM;
        linearLayout.clearAnimation();
        textView = this.bJT.bJN;
        personalChatActivity = this.bJT.bJK;
        textView.setText(personalChatActivity.getResources().getString(i.h.add_friend_agree_title, this.brH));
        textView2 = this.bJT.bJO;
        textView2.setText(this.bJV);
        linearLayout2 = this.bJT.bJM;
        linearLayout2.setAnimation(this.bJU);
    }
}
