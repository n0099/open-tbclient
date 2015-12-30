package com.baidu.tieba.person.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.newFriends.RequestUnreadPointNum;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements Runnable {
    final /* synthetic */ ah cRL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ah ahVar) {
        this.cRL = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.cRL.cRI;
        if (!z) {
            MessageManager.getInstance().dispatchResponsedMessage(new RequestUnreadPointNum());
        }
    }
}
