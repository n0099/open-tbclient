package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Animation.AnimationListener {
    private final /* synthetic */ String aXg;
    final /* synthetic */ PersonalChatView bpk;
    private final /* synthetic */ Animation bpl;
    private final /* synthetic */ String bpm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.bpk = personalChatView;
        this.aXg = str;
        this.bpm = str2;
        this.bpl = animation;
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
        linearLayout = this.bpk.bpe;
        linearLayout.clearAnimation();
        textView = this.bpk.bpf;
        personalChatActivity = this.bpk.bpc;
        textView.setText(personalChatActivity.getResources().getString(y.add_friend_agree_title, this.aXg));
        textView2 = this.bpk.bpg;
        textView2.setText(this.bpm);
        linearLayout2 = this.bpk.bpe;
        linearLayout2.setAnimation(this.bpl);
    }
}
