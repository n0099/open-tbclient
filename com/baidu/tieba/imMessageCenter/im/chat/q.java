package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ PersonalChatView bsg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalChatView personalChatView) {
        this.bsg = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        PersonalChatActivity personalChatActivity2;
        personalChatActivity = this.bsg.brY;
        if (personalChatActivity.Vq()) {
            this.bsg.SendMore1Event();
            return;
        }
        personalChatActivity2 = this.bsg.brY;
        personalChatActivity2.showToast(com.baidu.tieba.t.add_friend_cannot_send);
    }
}
