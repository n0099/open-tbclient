package com.baidu.tieba.mainentrance;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.tbadkCore.FRSPageSocketResponsedMessage;
/* loaded from: classes.dex */
class ab extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ SquareSearchActivity bzG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(SquareSearchActivity squareSearchActivity, int i, boolean z) {
        super(i, z);
        this.bzG = squareSearchActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        this.bzG.bzu = true;
        if (!(socketResponsedMessage instanceof FRSPageSocketResponsedMessage)) {
            return;
        }
        this.bzG.a(socketResponsedMessage, !((FRSPageSocketResponsedMessage) socketResponsedMessage).hasNetworkError());
    }
}
