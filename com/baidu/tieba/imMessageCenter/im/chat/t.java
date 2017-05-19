package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cJQ;
    final /* synthetic */ PersonalChatView ddP;
    private final /* synthetic */ Animation ddQ;
    private final /* synthetic */ String ddR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.ddP = personalChatView;
        this.cJQ = str;
        this.ddR = str2;
        this.ddQ = animation;
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
        linearLayout = this.ddP.ddI;
        linearLayout.clearAnimation();
        textView = this.ddP.ddJ;
        personalChatActivity = this.ddP.ddG;
        textView.setText(personalChatActivity.getResources().getString(w.l.add_friend_agree_title, this.cJQ));
        textView2 = this.ddP.ddK;
        textView2.setText(this.ddR);
        linearLayout2 = this.ddP.ddI;
        linearLayout2.setAnimation(this.ddQ);
    }
}
