package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView bJI;
    private final /* synthetic */ Animation bJJ;
    private final /* synthetic */ String bJK;
    private final /* synthetic */ String brw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.bJI = personalChatView;
        this.brw = str;
        this.bJK = str2;
        this.bJJ = animation;
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
        linearLayout = this.bJI.bJB;
        linearLayout.clearAnimation();
        textView = this.bJI.bJC;
        personalChatActivity = this.bJI.bJz;
        textView.setText(personalChatActivity.getResources().getString(i.h.add_friend_agree_title, this.brw));
        textView2 = this.bJI.bJD;
        textView2.setText(this.bJK);
        linearLayout2 = this.bJI.bJB;
        linearLayout2.setAnimation(this.bJJ);
    }
}
