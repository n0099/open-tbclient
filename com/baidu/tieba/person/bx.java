package com.baidu.tieba.person;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.person.bv;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bx extends CustomMessageListener {
    final /* synthetic */ bv dug;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(bv bvVar, int i) {
        super(i);
        this.dug = bvVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        bv.a aVar;
        bv.a aVar2;
        bv.a aVar3;
        bv.a aVar4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof ResponseLocalPersonListMessage)) {
            com.baidu.tieba.person.data.r data2 = ((ResponseLocalPersonListMessage) customResponsedMessage).getData2();
            if (data2 != null) {
                aVar3 = this.dug.dtS;
                if (aVar3 != null) {
                    aVar4 = this.dug.dtS;
                    aVar4.d(data2, true);
                    return;
                }
                return;
            }
            aVar = this.dug.dtS;
            if (aVar != null) {
                aVar2 = this.dug.dtS;
                aVar2.G("", true);
            }
        }
    }
}
