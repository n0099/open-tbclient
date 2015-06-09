package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity brV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.brV = personalChatActivity;
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
        absMsglistView = this.brV.mListView;
        userData = this.brV.mUser;
        String userName = userData.getUserName();
        bVar = this.brV.brM;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.brV.brL;
        if (j != 0) {
            handler = this.brV.mHandler;
            runnable = this.brV.brQ;
            j2 = this.brV.brL;
            handler.postDelayed(runnable, j2);
        }
    }
}
