package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    private final /* synthetic */ String bKY;
    final /* synthetic */ PersonalChatView cdt;
    private final /* synthetic */ Animation cdu;
    private final /* synthetic */ String cdv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.cdt = personalChatView;
        this.bKY = str;
        this.cdv = str2;
        this.cdu = animation;
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
        linearLayout = this.cdt.cdm;
        linearLayout.clearAnimation();
        textView = this.cdt.cdn;
        personalChatActivity = this.cdt.cdk;
        textView.setText(personalChatActivity.getResources().getString(n.j.add_friend_agree_title, this.bKY));
        textView2 = this.cdt.cdo;
        textView2.setText(this.cdv);
        linearLayout2 = this.cdt.cdm;
        linearLayout2.setAnimation(this.cdu);
    }
}
