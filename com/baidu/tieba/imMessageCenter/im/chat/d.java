package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity brU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.brU = personalChatActivity;
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
        absMsglistView = this.brU.mListView;
        userData = this.brU.mUser;
        String userName = userData.getUserName();
        bVar = this.brU.brL;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.brU.brK;
        if (j != 0) {
            handler = this.brU.mHandler;
            runnable = this.brU.brP;
            j2 = this.brU.brK;
            handler.postDelayed(runnable, j2);
        }
    }
}
