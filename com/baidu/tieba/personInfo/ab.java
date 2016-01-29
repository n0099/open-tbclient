package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends CustomMessageListener {
    final /* synthetic */ f diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(f fVar, int i) {
        super(i);
        this.diG = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        bf bfVar;
        bf bfVar2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            z = this.diG.cIp;
            if (z) {
                if (intValue == 0) {
                    bfVar2 = this.diG.dbl;
                    if (bfVar2.djm) {
                        this.diG.avw();
                        return;
                    }
                }
                bfVar = this.diG.dbl;
                if (bfVar.djm) {
                    return;
                }
                this.diG.avw();
            }
        }
    }
}
