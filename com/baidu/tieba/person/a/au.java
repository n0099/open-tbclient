package com.baidu.tieba.person.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements Runnable {
    final /* synthetic */ ar erH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ar arVar) {
        this.erH = arVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.erH.erD;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
