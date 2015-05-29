package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ PersonalChatView bsg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView) {
        this.bsg = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        PersonalChatActivity personalChatActivity2;
        personalChatActivity = this.bsg.brY;
        if (personalChatActivity.Vq()) {
            this.bsg.sendMore2Event();
            return;
        }
        personalChatActivity2 = this.bsg.brY;
        personalChatActivity2.showToast(com.baidu.tieba.t.add_friend_cannot_send);
    }
}
