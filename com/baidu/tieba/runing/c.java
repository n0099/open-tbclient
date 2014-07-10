package com.baidu.tieba.runing;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.message.ResponseQueryCollectUpdateNumMessage;
/* loaded from: classes.dex */
class c extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 303005 && (socketResponsedMessage instanceof ResponseQueryCollectUpdateNumMessage)) {
            com.baidu.tbadk.coreExtra.messageCenter.a.a().e(((ResponseQueryCollectUpdateNumMessage) socketResponsedMessage).getCollectUpdateNum());
        }
    }
}
