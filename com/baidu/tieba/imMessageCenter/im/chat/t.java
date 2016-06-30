package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cET;
    final /* synthetic */ PersonalChatView cYK;
    private final /* synthetic */ Animation cYL;
    private final /* synthetic */ String cYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.cYK = personalChatView;
        this.cET = str;
        this.cYM = str2;
        this.cYL = animation;
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
        linearLayout = this.cYK.cYD;
        linearLayout.clearAnimation();
        textView = this.cYK.cYE;
        personalChatActivity = this.cYK.cYB;
        textView.setText(personalChatActivity.getResources().getString(u.j.add_friend_agree_title, this.cET));
        textView2 = this.cYK.cYF;
        textView2.setText(this.cYM);
        linearLayout2 = this.cYK.cYD;
        linearLayout2.setAnimation(this.cYL);
    }
}
