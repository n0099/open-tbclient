package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eb extends CustomMessageListener {
    final /* synthetic */ dz dmN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eb(dz dzVar, int i) {
        super(i);
        this.dmN = dzVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.at)) {
            int qx = ((com.baidu.tbadk.core.data.at) customResponsedMessage.getData()).qx();
            this.dmN.dmJ = false;
            switch (qx) {
                case 9:
                    this.dmN.u(this.dmN.dmC, false);
                    return;
                case 10:
                    this.dmN.u(this.dmN.dmC + 1, true);
                    return;
                case 11:
                    this.dmN.dmJ = true;
                    this.dmN.u(this.dmN.dmC - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.dmN.dmG = 0;
                    this.dmN.dmC = 0;
                    return;
            }
        }
    }
}
