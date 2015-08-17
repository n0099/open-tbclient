package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity bFJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.bFJ = personalChatActivity;
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
        absMsglistView = this.bFJ.mListView;
        userData = this.bFJ.mUser;
        String userName = userData.getUserName();
        bVar = this.bFJ.bFA;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.bFJ.bFz;
        if (j != 0) {
            handler = this.bFJ.mHandler;
            runnable = this.bFJ.bFE;
            j2 = this.bFJ.bFz;
            handler.postDelayed(runnable, j2);
        }
    }
}
