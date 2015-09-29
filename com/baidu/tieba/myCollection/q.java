package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends CustomMessageListener {
    final /* synthetic */ p cbK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.cbK = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.myCollection.baseEditMark.a aVar;
        u uVar;
        u uVar2;
        u uVar3;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            if (com.baidu.adp.lib.util.i.iM()) {
                aVar = this.cbK.cbn;
                aVar.f(false);
                return;
            }
            uVar = this.cbK.cbJ;
            uVar.MW();
            uVar2 = this.cbK.cbJ;
            uVar2.completePullRefresh();
            uVar3 = this.cbK.cbJ;
            uVar3.bj(false);
        }
    }
}
