package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes2.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity dqT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.dqT = personalChatActivity;
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
        absMsglistView = this.dqT.cYg;
        userData = this.dqT.mUser;
        String name_show = userData.getName_show();
        bVar = this.dqT.dqK;
        absMsglistView.refreshPersonalHeadFooter(name_show, bVar);
        j = this.dqT.dqJ;
        if (j != 0) {
            handler = this.dqT.mHandler;
            runnable = this.dqT.dqO;
            j2 = this.dqT.dqJ;
            handler.postDelayed(runnable, j2);
        }
    }
}
