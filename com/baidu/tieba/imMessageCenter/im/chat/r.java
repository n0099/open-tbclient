package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ PersonalChatView bpA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PersonalChatView personalChatView) {
        this.bpA = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        PersonalChatActivity personalChatActivity2;
        personalChatActivity = this.bpA.bps;
        if (personalChatActivity.Uc()) {
            this.bpA.sendGovoiceEvent();
            return;
        }
        personalChatActivity2 = this.bpA.bps;
        personalChatActivity2.showToast(y.add_friend_cannot_send);
    }
}
