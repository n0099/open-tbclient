package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fa extends CustomMessageListener {
    final /* synthetic */ ey erL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fa(ey eyVar, int i) {
        super(i);
        this.erL = eyVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.bh)) {
            int qV = ((com.baidu.tbadk.core.data.bh) customResponsedMessage.getData()).qV();
            this.erL.erH = false;
            switch (qV) {
                case 9:
                    this.erL.z(this.erL.erA, false);
                    return;
                case 10:
                    this.erL.z(this.erL.erA + 1, true);
                    return;
                case 11:
                    this.erL.erH = true;
                    this.erL.z(this.erL.erA - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.erL.erE = 0;
                    this.erL.erA = 0;
                    return;
            }
        }
    }
}
