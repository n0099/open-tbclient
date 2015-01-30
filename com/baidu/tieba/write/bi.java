package com.baidu.tieba.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class bi extends CustomMessageListener {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(WriteActivity writeActivity, int i) {
        super(i);
        this.cgS = writeActivity;
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
                dVar2 = this.cgS.aBF;
                dVar2.eE(false);
                dVar3 = this.cgS.aBF;
                dVar3.aS(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                kVar2 = this.cgS.cgz;
                kVar2.B(2, responsedSelectLocation.getName());
                return;
            }
            dVar = this.cgS.aBF;
            dVar.eE(true);
            kVar = this.cgS.cgz;
            kVar.setLocationInfoViewState(0);
        }
    }
}
