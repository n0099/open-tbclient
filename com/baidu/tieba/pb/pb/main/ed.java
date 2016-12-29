package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ed extends CustomMessageListener {
    final /* synthetic */ eb eej;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ed(eb ebVar, int i) {
        super(i);
        this.eej = ebVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.bc)) {
            int rg = ((com.baidu.tbadk.core.data.bc) customResponsedMessage.getData()).rg();
            this.eej.eef = false;
            switch (rg) {
                case 9:
                    this.eej.A(this.eej.edY, false);
                    return;
                case 10:
                    this.eej.A(this.eej.edY + 1, true);
                    return;
                case 11:
                    this.eej.eef = true;
                    this.eej.A(this.eej.edY - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.eej.eec = 0;
                    this.eej.edY = 0;
                    return;
            }
        }
    }
}
