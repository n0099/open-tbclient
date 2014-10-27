package com.baidu.tieba.service;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* loaded from: classes.dex */
class s extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ TiebaSyncService bIS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TiebaSyncService tiebaSyncService, int i) {
        super(i);
        this.bIS = tiebaSyncService;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 1001 && (socketResponsedMessage instanceof ResponseOnlineMessage)) {
            ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
            if (socketResponsedMessage.getError() == 0) {
                this.bIS.checkVersion(responseOnlineMessage.getConfigVersion().sync);
            }
        }
    }
}
