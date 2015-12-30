package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CustomMessageListener {
    final /* synthetic */ d cWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(d dVar, int i) {
        super(i);
        this.cWV = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.person.a.ah ahVar;
        com.baidu.tieba.person.a.ah ahVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.cWV.cBJ = false;
                ahVar = this.cWV.cWq;
                if (ahVar != null) {
                    ahVar2 = this.cWV.cWq;
                    ahVar2.fF(false);
                    return;
                }
                return;
            }
            this.cWV.onUserChanged(false);
        }
    }
}
