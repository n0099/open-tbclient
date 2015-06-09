package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
/* loaded from: classes.dex */
class q implements View.OnClickListener {
    final /* synthetic */ PersonalChatView bsh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalChatView personalChatView) {
        this.bsh = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        PersonalChatActivity personalChatActivity2;
        personalChatActivity = this.bsh.brZ;
        if (personalChatActivity.Vr()) {
            this.bsh.SendMore1Event();
            return;
        }
        personalChatActivity2 = this.bsh.brZ;
        personalChatActivity2.showToast(com.baidu.tieba.t.add_friend_cannot_send);
    }
}
