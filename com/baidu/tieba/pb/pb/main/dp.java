package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp extends CustomMessageListener {
    final /* synthetic */ dn cPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp(dn dnVar, int i) {
        super(i);
        this.cPX = dnVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.ad)) {
            int sX = ((com.baidu.tbadk.core.data.ad) customResponsedMessage.getData()).sX();
            this.cPX.cPT = false;
            switch (sX) {
                case 9:
                    dn dnVar = this.cPX;
                    i3 = this.cPX.cPN;
                    dnVar.s(i3, false);
                    return;
                case 10:
                    dn dnVar2 = this.cPX;
                    i = this.cPX.cPN;
                    dnVar2.s(i + 1, true);
                    return;
                case 11:
                    this.cPX.cPT = true;
                    dn dnVar3 = this.cPX;
                    i2 = this.cPX.cPN;
                    dnVar3.s(i2 - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.cPX.cPQ = 0;
                    this.cPX.cPN = 0;
                    return;
            }
        }
    }
}
