package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.AbsMsglistView;
/* loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ PersonalChatActivity bpo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PersonalChatActivity personalChatActivity) {
        this.bpo = personalChatActivity;
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
        absMsglistView = this.bpo.mListView;
        userData = this.bpo.mUser;
        String userName = userData.getUserName();
        bVar = this.bpo.bpf;
        absMsglistView.refreshPersonalHeadFooter(userName, bVar);
        j = this.bpo.bpe;
        if (j != 0) {
            handler = this.bpo.mHandler;
            runnable = this.bpo.bpj;
            j2 = this.bpo.bpe;
            handler.postDelayed(runnable, j2);
        }
    }
}
