package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity dbu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.dbu = personalChatActivity;
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
        absMsglistView = this.dbu.cIF;
        userData = this.dbu.mUser;
        String userName = userData.getUserName();
        bVar = this.dbu.dbl;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.dbu.dbk;
        if (j != 0) {
            handler = this.dbu.mHandler;
            runnable = this.dbu.dbp;
            j2 = this.dbu.dbk;
            handler.postDelayed(runnable, j2);
        }
    }
}
