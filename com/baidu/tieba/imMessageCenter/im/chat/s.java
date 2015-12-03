package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Animation.AnimationListener {
    private final /* synthetic */ String bHr;
    final /* synthetic */ PersonalChatView bZt;
    private final /* synthetic */ Animation bZu;
    private final /* synthetic */ String bZv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.bZt = personalChatView;
        this.bHr = str;
        this.bZv = str2;
        this.bZu = animation;
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
        linearLayout = this.bZt.bZm;
        linearLayout.clearAnimation();
        textView = this.bZt.bZn;
        personalChatActivity = this.bZt.bZk;
        textView.setText(personalChatActivity.getResources().getString(n.i.add_friend_agree_title, this.bHr));
        textView2 = this.bZt.bZo;
        textView2.setText(this.bZv);
        linearLayout2 = this.bZt.bZm;
        linearLayout2.setAnimation(this.bZu);
    }
}
