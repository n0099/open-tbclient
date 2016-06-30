package com.baidu.tieba.person.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements Runnable {
    final /* synthetic */ at ehI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(at atVar) {
        this.ehI = atVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.ehI.ehE;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
