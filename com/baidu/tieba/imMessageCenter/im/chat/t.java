package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cFC;
    final /* synthetic */ PersonalChatView cZq;
    private final /* synthetic */ Animation cZr;
    private final /* synthetic */ String cZs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.cZq = personalChatView;
        this.cFC = str;
        this.cZs = str2;
        this.cZr = animation;
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
        linearLayout = this.cZq.cZj;
        linearLayout.clearAnimation();
        textView = this.cZq.cZk;
        personalChatActivity = this.cZq.cZh;
        textView.setText(personalChatActivity.getResources().getString(r.j.add_friend_agree_title, this.cFC));
        textView2 = this.cZq.cZl;
        textView2.setText(this.cZs);
        linearLayout2 = this.cZq.cZj;
        linearLayout2.setAnimation(this.cZr);
    }
}
