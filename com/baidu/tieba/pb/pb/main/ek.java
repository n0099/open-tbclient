package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ek extends CustomMessageListener {
    final /* synthetic */ ei dko;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ek(ei eiVar, int i) {
        super(i);
        this.dko = eiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ao)) {
            int sY = ((com.baidu.tbadk.core.data.ao) customResponsedMessage.getData()).sY();
            this.dko.dkk = false;
            switch (sY) {
                case 9:
                    ei eiVar = this.dko;
                    i3 = this.dko.dke;
                    eiVar.s(i3, false);
                    return;
                case 10:
                    ei eiVar2 = this.dko;
                    i = this.dko.dke;
                    eiVar2.s(i + 1, true);
                    return;
                case 11:
                    this.dko.dkk = true;
                    ei eiVar3 = this.dko;
                    i2 = this.dko.dke;
                    eiVar3.s(i2 - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.dko.dkh = 0;
                    this.dko.dke = 0;
                    return;
            }
        }
    }
}
