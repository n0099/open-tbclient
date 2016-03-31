package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Animation.AnimationListener {
    private final /* synthetic */ String bZe;
    final /* synthetic */ PersonalChatView csx;
    private final /* synthetic */ Animation csy;
    private final /* synthetic */ String val$message;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.csx = personalChatView;
        this.bZe = str;
        this.val$message = str2;
        this.csy = animation;
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
        linearLayout = this.csx.csq;
        linearLayout.clearAnimation();
        textView = this.csx.csr;
        personalChatActivity = this.csx.cso;
        textView.setText(personalChatActivity.getResources().getString(t.j.add_friend_agree_title, this.bZe));
        textView2 = this.csx.css;
        textView2.setText(this.val$message);
        linearLayout2 = this.csx.csq;
        linearLayout2.setAnimation(this.csy);
    }
}
