package com.baidu.tieba.runing;

import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.message.ResponseQueryCollectUpdateNumMessage;
/* loaded from: classes.dex */
class c extends e {
    final /* synthetic */ a bIL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.bIL = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 303005 && (socketResponsedMessage instanceof ResponseQueryCollectUpdateNumMessage)) {
            com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgBookmark(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
        }
    }
}
