package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends CustomMessageListener {
    final /* synthetic */ bm bGT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(bm bmVar, int i) {
        super(i);
        this.bGT = bmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
            com.baidu.tbadk.core.data.q data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
            if (data2 != null) {
                bpVar3 = this.bGT.bGF;
                if (bpVar3 != null) {
                    bpVar4 = this.bGT.bGF;
                    bpVar4.d(data2, true);
                    return;
                }
                return;
            }
            bpVar = this.bGT.bGF;
            if (bpVar != null) {
                bpVar2 = this.bGT.bGF;
                bpVar2.B("", true);
            }
        }
    }
}
