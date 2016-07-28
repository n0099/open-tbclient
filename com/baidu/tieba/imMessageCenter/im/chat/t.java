package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cHI;
    final /* synthetic */ PersonalChatView dbH;
    private final /* synthetic */ Animation dbI;
    private final /* synthetic */ String dbJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.dbH = personalChatView;
        this.cHI = str;
        this.dbJ = str2;
        this.dbI = animation;
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
        linearLayout = this.dbH.dbA;
        linearLayout.clearAnimation();
        textView = this.dbH.dbB;
        personalChatActivity = this.dbH.dby;
        textView.setText(personalChatActivity.getResources().getString(u.j.add_friend_agree_title, this.cHI));
        textView2 = this.dbH.dbC;
        textView2.setText(this.dbJ);
        linearLayout2 = this.dbH.dbA;
        linearLayout2.setAnimation(this.dbI);
    }
}
