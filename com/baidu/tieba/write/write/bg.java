package com.baidu.tieba.write.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class bg extends CustomMessageListener {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(WriteActivity writeActivity, int i) {
        super(i);
        this.dsa = writeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.location.d dVar;
        com.baidu.tieba.tbadkCore.location.d dVar2;
        com.baidu.tieba.tbadkCore.location.d dVar3;
        if (customResponsedMessage instanceof ResponsedSelectLocation) {
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                dVar2 = this.dsa.aqu;
                dVar2.gB(false);
                dVar3 = this.dsa.aqu;
                dVar3.bf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                this.dsa.a(2, true, responsedSelectLocation.getName());
                return;
            }
            dVar = this.dsa.aqu;
            dVar.gB(true);
            this.dsa.a(0, true, (String) null);
        }
    }
}
