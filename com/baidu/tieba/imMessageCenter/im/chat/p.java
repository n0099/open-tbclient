package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ PersonalChatView bFW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PersonalChatView personalChatView) {
        this.bFW = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        personalChatActivity = this.bFW.bFN;
        personalChatActivity.showToast(i.C0057i.add_friend_cannot_send);
    }
}
