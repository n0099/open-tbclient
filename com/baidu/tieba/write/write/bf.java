package com.baidu.tieba.write.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class bf extends CustomMessageListener {
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(WriteActivity writeActivity, int i) {
        super(i);
        this.dpI = writeActivity;
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
                dVar2 = this.dpI.arU;
                dVar2.gv(false);
                dVar3 = this.dpI.arU;
                dVar3.bg(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                this.dpI.a(2, true, responsedSelectLocation.getName());
                return;
            }
            dVar = this.dpI.arU;
            dVar.gv(true);
            this.dpI.a(0, true, (String) null);
        }
    }
}
