package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei extends CustomMessageListener {
    final /* synthetic */ eg dTe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei(eg egVar, int i) {
        super(i);
        this.dTe = egVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.av)) {
            int qr = ((com.baidu.tbadk.core.data.av) customResponsedMessage.getData()).qr();
            this.dTe.dTa = false;
            switch (qr) {
                case 9:
                    this.dTe.I(this.dTe.dST, false);
                    return;
                case 10:
                    this.dTe.I(this.dTe.dST + 1, true);
                    return;
                case 11:
                    this.dTe.dTa = true;
                    this.dTe.I(this.dTe.dST - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.dTe.dSX = 0;
                    this.dTe.dST = 0;
                    return;
            }
        }
    }
}
