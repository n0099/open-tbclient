package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class el extends CustomMessageListener {
    final /* synthetic */ ej eqd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public el(ej ejVar, int i) {
        super(i);
        this.eqd = ejVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.bf)) {
            int rr = ((com.baidu.tbadk.core.data.bf) customResponsedMessage.getData()).rr();
            this.eqd.epZ = false;
            switch (rr) {
                case 9:
                    this.eqd.A(this.eqd.epS, false);
                    return;
                case 10:
                    this.eqd.A(this.eqd.epS + 1, true);
                    return;
                case 11:
                    this.eqd.epZ = true;
                    this.eqd.A(this.eqd.epS - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.eqd.epW = 0;
                    this.eqd.epS = 0;
                    return;
            }
        }
    }
}
