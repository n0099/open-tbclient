package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String daq;
    final /* synthetic */ PersonalChatView duv;
    private final /* synthetic */ Animation duw;
    private final /* synthetic */ String dux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.duv = personalChatView;
        this.daq = str;
        this.dux = str2;
        this.duw = animation;
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
        linearLayout = this.duv.duo;
        linearLayout.clearAnimation();
        textView = this.duv.dup;
        personalChatActivity = this.duv.dum;
        textView.setText(personalChatActivity.getResources().getString(r.j.add_friend_agree_title, this.daq));
        textView2 = this.duv.duq;
        textView2.setText(this.dux);
        linearLayout2 = this.duv.duo;
        linearLayout2.setAnimation(this.duw);
    }
}
