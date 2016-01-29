package com.baidu.tieba.person.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ al dbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.dbz = alVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.dbz.dbw;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
