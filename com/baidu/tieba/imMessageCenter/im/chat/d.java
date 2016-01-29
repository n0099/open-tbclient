package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity chF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.chF = personalChatActivity;
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
        absMsglistView = this.chF.bPJ;
        userData = this.chF.mUser;
        String userName = userData.getUserName();
        bVar = this.chF.chw;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.chF.chv;
        if (j != 0) {
            handler = this.chF.mHandler;
            runnable = this.chF.chA;
            j2 = this.chF.chv;
            handler.postDelayed(runnable, j2);
        }
    }
}
