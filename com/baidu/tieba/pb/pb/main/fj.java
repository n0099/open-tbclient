package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fj extends CustomMessageListener {
    final /* synthetic */ fh eAW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fj(fh fhVar, int i) {
        super(i);
        this.eAW = fhVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.bi)) {
            int qS = ((com.baidu.tbadk.core.data.bi) customResponsedMessage.getData()).qS();
            this.eAW.eAS = false;
            switch (qS) {
                case 9:
                    this.eAW.z(this.eAW.eAL, false);
                    return;
                case 10:
                    this.eAW.z(this.eAW.eAL + 1, true);
                    return;
                case 11:
                    this.eAW.eAS = true;
                    this.eAW.z(this.eAW.eAL - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.eAW.eAP = 0;
                    this.eAW.eAL = 0;
                    return;
            }
        }
    }
}
