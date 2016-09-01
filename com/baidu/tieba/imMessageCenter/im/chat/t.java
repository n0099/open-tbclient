package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cTo;
    final /* synthetic */ PersonalChatView dnp;
    private final /* synthetic */ Animation dnq;
    private final /* synthetic */ String dnr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.dnp = personalChatView;
        this.cTo = str;
        this.dnr = str2;
        this.dnq = animation;
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
        linearLayout = this.dnp.dni;
        linearLayout.clearAnimation();
        textView = this.dnp.dnj;
        personalChatActivity = this.dnp.dng;
        textView.setText(personalChatActivity.getResources().getString(t.j.add_friend_agree_title, this.cTo));
        textView2 = this.dnp.dnk;
        textView2.setText(this.dnr);
        linearLayout2 = this.dnp.dni;
        linearLayout2.setAnimation(this.dnq);
    }
}
