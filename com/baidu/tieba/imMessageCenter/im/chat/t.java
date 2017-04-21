package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cPN;
    final /* synthetic */ PersonalChatView djN;
    private final /* synthetic */ Animation djO;
    private final /* synthetic */ String djP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.djN = personalChatView;
        this.cPN = str;
        this.djP = str2;
        this.djO = animation;
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
        linearLayout = this.djN.djG;
        linearLayout.clearAnimation();
        textView = this.djN.djH;
        personalChatActivity = this.djN.djE;
        textView.setText(personalChatActivity.getResources().getString(w.l.add_friend_agree_title, this.cPN));
        textView2 = this.djN.djI;
        textView2.setText(this.djP);
        linearLayout2 = this.djN.djG;
        linearLayout2.setAnimation(this.djO);
    }
}
