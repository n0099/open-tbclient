package com.baidu.tieba.person.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements Runnable {
    final /* synthetic */ as dze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar) {
        this.dze = asVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.dze.dza;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
