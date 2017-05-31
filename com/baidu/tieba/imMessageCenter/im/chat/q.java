package com.baidu.tieba.imMessageCenter.im.chat;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ PersonalChatView djk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalChatView personalChatView) {
        this.djk = personalChatView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonalChatActivity personalChatActivity;
        personalChatActivity = this.djk.djb;
        personalChatActivity.showToast(w.l.add_friend_cannot_send);
    }
}
