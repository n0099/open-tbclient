package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab extends CustomMessageListener {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        bp bpVar;
        bp bpVar2;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            z = this.this$0.dyP;
            if (z) {
                if (intValue == 0) {
                    bpVar2 = this.this$0.eht;
                    if (bpVar2.eqb) {
                        this.this$0.aMu();
                        return;
                    }
                }
                bpVar = this.this$0.eht;
                if (bpVar.eqb) {
                    return;
                }
                this.this$0.aMu();
            }
        }
    }
}
