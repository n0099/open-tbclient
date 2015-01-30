package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends CustomMessageListener {
    final /* synthetic */ bl bIF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bl blVar, int i) {
        super(i);
        this.bIF = blVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bo boVar;
        bo boVar2;
        bo boVar3;
        bo boVar4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
            com.baidu.tbadk.core.data.r data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
            if (data2 != null) {
                boVar3 = this.bIF.bIr;
                if (boVar3 != null) {
                    boVar4 = this.bIF.bIr;
                    boVar4.d(data2, true);
                    return;
                }
                return;
            }
            boVar = this.bIF.bIr;
            if (boVar != null) {
                boVar2 = this.bIF.bIr;
                boVar2.A("", true);
            }
        }
    }
}
