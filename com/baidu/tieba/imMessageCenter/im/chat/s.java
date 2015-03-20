package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class s implements View.OnClickListener {
    final /* synthetic */ PersonalChatView bpk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonalChatView personalChatView) {
        this.bpk = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        PersonalChatActivity personalChatActivity2;
        personalChatActivity = this.bpk.bpc;
        if (personalChatActivity.TP()) {
            this.bpk.sendMore2Event();
            return;
        }
        personalChatActivity2 = this.bpk.bpc;
        personalChatActivity2.showToast(y.add_friend_cannot_send);
    }
}
