package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ PersonalChatView cZq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalChatView personalChatView) {
        this.cZq = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        personalChatActivity = this.cZq.cZh;
        personalChatActivity.showToast(r.j.add_friend_cannot_send);
    }
}
