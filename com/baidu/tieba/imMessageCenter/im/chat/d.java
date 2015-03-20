package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity boY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.boY = personalChatActivity;
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
        absMsglistView = this.boY.mListView;
        userData = this.boY.mUser;
        String userName = userData.getUserName();
        bVar = this.boY.boP;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.boY.boO;
        if (j != 0) {
            handler = this.boY.mHandler;
            runnable = this.boY.boT;
            j2 = this.boY.boO;
            handler.postDelayed(runnable, j2);
        }
    }
}
