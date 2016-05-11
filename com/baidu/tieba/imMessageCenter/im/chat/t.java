package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String bZJ;
    final /* synthetic */ PersonalChatView ctu;
    private final /* synthetic */ Animation ctv;
    private final /* synthetic */ String ctw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.ctu = personalChatView;
        this.bZJ = str;
        this.ctw = str2;
        this.ctv = animation;
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
        linearLayout = this.ctu.ctn;
        linearLayout.clearAnimation();
        textView = this.ctu.cto;
        personalChatActivity = this.ctu.ctl;
        textView.setText(personalChatActivity.getResources().getString(t.j.add_friend_agree_title, this.bZJ));
        textView2 = this.ctu.ctp;
        textView2.setText(this.ctw);
        linearLayout2 = this.ctu.ctn;
        linearLayout2.setAnimation(this.ctv);
    }
}
