package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
/* loaded from: classes.dex */
class x extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ SquareSearchActivity bCE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(SquareSearchActivity squareSearchActivity, int i, boolean z) {
        super(i, z);
        this.bCE = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.bCE.bCm = true;
        if (!(socketResponsedMessage instanceof FRSPageSocketResponsedMessage)) {
            return;
        }
        this.bCE.a(socketResponsedMessage, !((FRSPageSocketResponsedMessage) socketResponsedMessage).hasNetworkError());
    }
}
