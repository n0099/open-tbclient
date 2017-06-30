package com.baidu.tieba.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ a fvW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.fvW = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.fvW.fvO;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
