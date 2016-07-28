package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ej extends CustomMessageListener {
    final /* synthetic */ eh efv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ej(eh ehVar, int i) {
        super(i);
        this.efv = ehVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ba)) {
            int qa = ((com.baidu.tbadk.core.data.ba) customResponsedMessage.getData()).qa();
            this.efv.efr = false;
            switch (qa) {
                case 9:
                    this.efv.M(this.efv.efk, false);
                    return;
                case 10:
                    this.efv.M(this.efv.efk + 1, true);
                    return;
                case 11:
                    this.efv.efr = true;
                    this.efv.M(this.efv.efk - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.efv.efo = 0;
                    this.efv.efk = 0;
                    return;
            }
        }
    }
}
