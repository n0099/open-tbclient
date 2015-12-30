package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity cdg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.cdg = personalChatActivity;
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
        absMsglistView = this.cdg.mListView;
        userData = this.cdg.mUser;
        String userName = userData.getUserName();
        bVar = this.cdg.ccX;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.cdg.ccW;
        if (j != 0) {
            handler = this.cdg.mHandler;
            runnable = this.cdg.cdb;
            j2 = this.cdg.ccW;
            handler.postDelayed(runnable, j2);
        }
    }
}
