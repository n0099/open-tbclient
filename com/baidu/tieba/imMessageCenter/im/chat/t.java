package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cMK;
    final /* synthetic */ PersonalChatView dgF;
    private final /* synthetic */ Animation dgG;
    private final /* synthetic */ String dgH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.dgF = personalChatView;
        this.cMK = str;
        this.dgH = str2;
        this.dgG = animation;
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
        linearLayout = this.dgF.dgy;
        linearLayout.clearAnimation();
        textView = this.dgF.dgz;
        personalChatActivity = this.dgF.dgw;
        textView.setText(personalChatActivity.getResources().getString(r.l.add_friend_agree_title, this.cMK));
        textView2 = this.dgF.dgA;
        textView2.setText(this.dgH);
        linearLayout2 = this.dgF.dgy;
        linearLayout2.setAnimation(this.dgG);
    }
}
