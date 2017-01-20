package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ek extends CustomMessageListener {
    final /* synthetic */ ei ene;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ek(ei eiVar, int i) {
        super(i);
        this.ene = eiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.bd)) {
            int qY = ((com.baidu.tbadk.core.data.bd) customResponsedMessage.getData()).qY();
            this.ene.emZ = false;
            switch (qY) {
                case 9:
                    this.ene.A(this.ene.emS, false);
                    return;
                case 10:
                    this.ene.A(this.ene.emS + 1, true);
                    return;
                case 11:
                    this.ene.emZ = true;
                    this.ene.A(this.ene.emS - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.ene.emW = 0;
                    this.ene.emS = 0;
                    return;
            }
        }
    }
}
