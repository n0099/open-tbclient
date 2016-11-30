package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends CustomMessageListener {
    final /* synthetic */ x eSp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(x xVar, int i) {
        super(i);
        this.eSp = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.data.k kVar;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.k) && (kVar = (com.baidu.tbadk.data.k) customResponsedMessage.getData()) != null) {
            this.eSp.gfM.pV(kVar.pR());
        }
    }
}
