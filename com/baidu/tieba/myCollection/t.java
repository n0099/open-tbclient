package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ s cFe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.cFe = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.myCollection.baseEditMark.a aVar;
        x xVar;
        x xVar2;
        x xVar3;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            if (com.baidu.adp.lib.util.i.iZ()) {
                aVar = this.cFe.cEH;
                aVar.f(false);
                return;
            }
            xVar = this.cFe.cFd;
            xVar.Rh();
            xVar2 = this.cFe.cFd;
            xVar2.nr();
            xVar3 = this.cFe.cFd;
            xVar3.bw(false);
        }
    }
}
