package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cXk;
    final /* synthetic */ PersonalChatView drg;
    private final /* synthetic */ Animation drh;
    private final /* synthetic */ String dri;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.drg = personalChatView;
        this.cXk = str;
        this.dri = str2;
        this.drh = animation;
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
        linearLayout = this.drg.dqZ;
        linearLayout.clearAnimation();
        textView = this.drg.dra;
        personalChatActivity = this.drg.dqX;
        textView.setText(personalChatActivity.getResources().getString(w.l.add_friend_agree_title, this.cXk));
        textView2 = this.drg.drb;
        textView2.setText(this.dri);
        linearLayout2 = this.drg.dqZ;
        linearLayout2.setAnimation(this.drh);
    }
}
