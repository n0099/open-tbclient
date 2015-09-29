package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ PersonalChatView bJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PersonalChatView personalChatView) {
        this.bJI = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        personalChatActivity = this.bJI.bJz;
        personalChatActivity.showToast(i.h.add_friend_cannot_send);
    }
}
