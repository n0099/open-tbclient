package com.baidu.tieba.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class bi extends CustomMessageListener {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(WriteActivity writeActivity, int i) {
        super(i);
        this.cft = writeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.location.d dVar;
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        com.baidu.tieba.tbadkCore.location.d dVar2;
        com.baidu.tieba.tbadkCore.location.d dVar3;
        com.baidu.tieba.tbadkCore.PbEditor.k kVar2;
        if (customResponsedMessage instanceof ResponsedSelectLocation) {
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                dVar2 = this.cft.aAD;
                dVar2.ex(false);
                dVar3 = this.cft.aAD;
                dVar3.aP(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                kVar2 = this.cft.cfa;
                kVar2.B(2, responsedSelectLocation.getName());
                return;
            }
            dVar = this.cft.aAD;
            dVar.ex(true);
            kVar = this.cft.cfa;
            kVar.setLocationInfoViewState(0);
        }
    }
}
