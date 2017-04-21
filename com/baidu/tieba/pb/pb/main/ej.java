package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ej extends CustomMessageListener {
    final /* synthetic */ eh eqD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ej(eh ehVar, int i) {
        super(i);
        this.eqD = ehVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.be)) {
            int rP = ((com.baidu.tbadk.core.data.be) customResponsedMessage.getData()).rP();
            this.eqD.eqz = false;
            switch (rP) {
                case 9:
                    this.eqD.A(this.eqD.eqs, false);
                    return;
                case 10:
                    this.eqD.A(this.eqD.eqs + 1, true);
                    return;
                case 11:
                    this.eqD.eqz = true;
                    this.eqD.A(this.eqD.eqs - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.eqD.eqw = 0;
                    this.eqD.eqs = 0;
                    return;
            }
        }
    }
}
