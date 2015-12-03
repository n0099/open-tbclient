package com.baidu.tieba.person.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Runnable {
    final /* synthetic */ ad cNh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ad adVar) {
        this.cNh = adVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.cNh.cNe;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
