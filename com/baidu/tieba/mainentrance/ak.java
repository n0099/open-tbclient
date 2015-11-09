package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
/* loaded from: classes.dex */
class ak extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ SquareSearchActivity bWd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(SquareSearchActivity squareSearchActivity, int i, boolean z) {
        super(i, z);
        this.bWd = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.bWd.aqa = true;
        if (!(socketResponsedMessage instanceof FRSPageSocketResponsedMessage)) {
            return;
        }
        this.bWd.a(socketResponsedMessage, !((FRSPageSocketResponsedMessage) socketResponsedMessage).hasNetworkError());
    }
}
