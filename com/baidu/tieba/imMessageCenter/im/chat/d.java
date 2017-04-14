package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity dhj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.dhj = personalChatActivity;
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
        absMsglistView = this.dhj.cOt;
        userData = this.dhj.mUser;
        String userName = userData.getUserName();
        bVar = this.dhj.dha;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.dhj.dgZ;
        if (j != 0) {
            handler = this.dhj.mHandler;
            runnable = this.dhj.dhe;
            j2 = this.dhj.dgZ;
            handler.postDelayed(runnable, j2);
        }
    }
}
