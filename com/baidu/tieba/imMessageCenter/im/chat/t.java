package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String cPo;
    final /* synthetic */ PersonalChatView djk;
    private final /* synthetic */ Animation djl;
    private final /* synthetic */ String djm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.djk = personalChatView;
        this.cPo = str;
        this.djm = str2;
        this.djl = animation;
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
        linearLayout = this.djk.djd;
        linearLayout.clearAnimation();
        textView = this.djk.dje;
        personalChatActivity = this.djk.djb;
        textView.setText(personalChatActivity.getResources().getString(w.l.add_friend_agree_title, this.cPo));
        textView2 = this.djk.djf;
        textView2.setText(this.djm);
        linearLayout2 = this.djk.djd;
        linearLayout2.setAnimation(this.djl);
    }
}
