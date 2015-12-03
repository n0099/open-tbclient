package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity bZg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.bZg = personalChatActivity;
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
        absMsglistView = this.bZg.mListView;
        userData = this.bZg.mUser;
        String userName = userData.getUserName();
        bVar = this.bZg.bYX;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.bZg.bYW;
        if (j != 0) {
            handler = this.bZg.mHandler;
            runnable = this.bZg.bZb;
            j2 = this.bZg.bYW;
            handler.postDelayed(runnable, j2);
        }
    }
}
