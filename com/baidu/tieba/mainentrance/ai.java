package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
/* loaded from: classes.dex */
class ai extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ SquareSearchActivity cwZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(SquareSearchActivity squareSearchActivity, int i, boolean z) {
        super(i, z);
        this.cwZ = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.cwZ.aut = true;
        if (!(socketResponsedMessage instanceof FRSPageSocketResponsedMessage)) {
            return;
        }
        this.cwZ.a(socketResponsedMessage, !((FRSPageSocketResponsedMessage) socketResponsedMessage).hasNetworkError());
    }
}
