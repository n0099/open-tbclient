package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String bOM;
    final /* synthetic */ PersonalChatView chS;
    private final /* synthetic */ Animation chT;
    private final /* synthetic */ String val$message;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.chS = personalChatView;
        this.bOM = str;
        this.val$message = str2;
        this.chT = animation;
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
        linearLayout = this.chS.chL;
        linearLayout.clearAnimation();
        textView = this.chS.chM;
        personalChatActivity = this.chS.chJ;
        textView.setText(personalChatActivity.getResources().getString(t.j.add_friend_agree_title, this.bOM));
        textView2 = this.chS.chN;
        textView2.setText(this.val$message);
        linearLayout2 = this.chS.chL;
        linearLayout2.setAnimation(this.chT);
    }
}
