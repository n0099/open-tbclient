package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ej extends CustomMessageListener {
    final /* synthetic */ eh etJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ej(eh ehVar, int i) {
        super(i);
        this.etJ = ehVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.be)) {
            int rp = ((com.baidu.tbadk.core.data.be) customResponsedMessage.getData()).rp();
            this.etJ.etF = false;
            switch (rp) {
                case 9:
                    this.etJ.M(this.etJ.ety, false);
                    return;
                case 10:
                    this.etJ.M(this.etJ.ety + 1, true);
                    return;
                case 11:
                    this.etJ.etF = true;
                    this.etJ.M(this.etJ.ety - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.etJ.etC = 0;
                    this.etJ.ety = 0;
                    return;
            }
        }
    }
}
