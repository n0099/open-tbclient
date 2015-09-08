package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ PersonalChatView bGD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PersonalChatView personalChatView) {
        this.bGD = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        personalChatActivity = this.bGD.bGu;
        personalChatActivity.showToast(i.h.add_friend_cannot_send);
    }
}
