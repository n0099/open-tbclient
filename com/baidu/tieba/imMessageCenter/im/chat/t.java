package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cNw;
    final /* synthetic */ PersonalChatView dhw;
    private final /* synthetic */ Animation dhx;
    private final /* synthetic */ String dhy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.dhw = personalChatView;
        this.cNw = str;
        this.dhy = str2;
        this.dhx = animation;
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
        linearLayout = this.dhw.dhp;
        linearLayout.clearAnimation();
        textView = this.dhw.dhq;
        personalChatActivity = this.dhw.dhn;
        textView.setText(personalChatActivity.getResources().getString(w.l.add_friend_agree_title, this.cNw));
        textView2 = this.dhw.dhr;
        textView2.setText(this.dhy);
        linearLayout2 = this.dhw.dhp;
        linearLayout2.setAnimation(this.dhx);
    }
}
