package com.baidu.tieba.person.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements Runnable {
    final /* synthetic */ al dwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.dwc = alVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.dwc.dvY;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
