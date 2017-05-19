package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class er extends CustomMessageListener {
    final /* synthetic */ ep elY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public er(ep epVar, int i) {
        super(i);
        this.elY = epVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.bg)) {
            int qZ = ((com.baidu.tbadk.core.data.bg) customResponsedMessage.getData()).qZ();
            this.elY.elU = false;
            switch (qZ) {
                case 9:
                    this.elY.z(this.elY.elN, false);
                    return;
                case 10:
                    this.elY.z(this.elY.elN + 1, true);
                    return;
                case 11:
                    this.elY.elU = true;
                    this.elY.z(this.elY.elN - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.elY.elR = 0;
                    this.elY.elN = 0;
                    return;
            }
        }
    }
}
