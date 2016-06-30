package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity cYx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.cYx = personalChatActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbsMsglistView absMsglistView;
        UserData userData;
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        long j;
        Handler handler;
        Runnable runnable;
        long j2;
        absMsglistView = this.cYx.cFQ;
        userData = this.cYx.mUser;
        String userName = userData.getUserName();
        bVar = this.cYx.cYo;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.cYx.cYn;
        if (j != 0) {
            handler = this.cYx.mHandler;
            runnable = this.cYx.cYs;
            j2 = this.cYx.cYn;
            handler.postDelayed(runnable, j2);
        }
    }
}
