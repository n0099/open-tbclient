package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends CustomMessageListener {
    final /* synthetic */ s cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(s sVar, int i) {
        super(i);
        this.cyx = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.myCollection.baseEditMark.a aVar;
        x xVar;
        x xVar2;
        x xVar3;
        if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
            if (com.baidu.adp.lib.util.i.iQ()) {
                aVar = this.cyx.cya;
                aVar.f(false);
                return;
            }
            xVar = this.cyx.cyw;
            xVar.Pe();
            xVar2 = this.cyx.cyw;
            xVar2.completePullRefresh();
            xVar3 = this.cyx.cyw;
            xVar3.bu(false);
        }
    }
}
