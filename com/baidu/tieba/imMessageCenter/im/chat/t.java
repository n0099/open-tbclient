package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cOZ;
    final /* synthetic */ PersonalChatView diX;
    private final /* synthetic */ Animation diY;
    private final /* synthetic */ String diZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.diX = personalChatView;
        this.cOZ = str;
        this.diZ = str2;
        this.diY = animation;
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
        linearLayout = this.diX.diQ;
        linearLayout.clearAnimation();
        textView = this.diX.diR;
        personalChatActivity = this.diX.diO;
        textView.setText(personalChatActivity.getResources().getString(w.l.add_friend_agree_title, this.cOZ));
        textView2 = this.diX.diS;
        textView2.setText(this.diZ);
        linearLayout2 = this.diX.diQ;
        linearLayout2.setAnimation(this.diY);
    }
}
