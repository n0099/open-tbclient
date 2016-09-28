package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cUI;
    final /* synthetic */ PersonalChatView doN;
    private final /* synthetic */ Animation doO;
    private final /* synthetic */ String doP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.doN = personalChatView;
        this.cUI = str;
        this.doP = str2;
        this.doO = animation;
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
        linearLayout = this.doN.doG;
        linearLayout.clearAnimation();
        textView = this.doN.doH;
        personalChatActivity = this.doN.doE;
        textView.setText(personalChatActivity.getResources().getString(r.j.add_friend_agree_title, this.cUI));
        textView2 = this.doN.doI;
        textView2.setText(this.doP);
        linearLayout2 = this.doN.doG;
        linearLayout2.setAnimation(this.doO);
    }
}
