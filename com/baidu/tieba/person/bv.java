package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.person.bt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends CustomMessageListener {
    final /* synthetic */ bt csw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv(bt btVar, int i) {
        super(i);
        this.csw = btVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bt.a aVar;
        bt.a aVar2;
        bt.a aVar3;
        bt.a aVar4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
            com.baidu.tieba.person.data.a data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
            if (data2 != null) {
                aVar3 = this.csw.csi;
                if (aVar3 != null) {
                    aVar4 = this.csw.csi;
                    aVar4.d(data2, true);
                    return;
                }
                return;
            }
            aVar = this.csw.csi;
            if (aVar != null) {
                aVar2 = this.csw.csi;
                aVar2.E("", true);
            }
        }
    }
}
