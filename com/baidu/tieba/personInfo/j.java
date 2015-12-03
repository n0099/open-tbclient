package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends CustomMessageListener {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d dVar, int i) {
        super(i);
        this.cSn = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.person.a.ad adVar;
        com.baidu.tieba.person.a.ad adVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                this.cSn.cyc = false;
                adVar = this.cSn.cRN;
                if (adVar != null) {
                    adVar2 = this.cSn.cRN;
                    adVar2.fG(false);
                    return;
                }
                return;
            }
            this.cSn.onUserChanged(false);
        }
    }
}
