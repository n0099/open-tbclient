package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity dgs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.dgs = personalChatActivity;
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
        absMsglistView = this.dgs.cNH;
        userData = this.dgs.mUser;
        String userName = userData.getUserName();
        bVar = this.dgs.dgj;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.dgs.dgi;
        if (j != 0) {
            handler = this.dgs.mHandler;
            runnable = this.dgs.dgn;
            j2 = this.dgs.dgi;
            handler.postDelayed(runnable, j2);
        }
    }
}
