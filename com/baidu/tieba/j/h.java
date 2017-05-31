package com.baidu.tieba.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ a flI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.flI = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.flI.flA;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
