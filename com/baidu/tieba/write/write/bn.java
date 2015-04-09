package com.baidu.tieba.write.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class bn extends CustomMessageListener {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(WriteActivity writeActivity, int i) {
        super(i);
        this.cyx = writeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.tbadkCore.location.e eVar;
        com.baidu.tieba.write.editor.b bVar;
        com.baidu.tieba.tbadkCore.location.e eVar2;
        com.baidu.tieba.tbadkCore.location.e eVar3;
        com.baidu.tieba.write.editor.b bVar2;
        if (customResponsedMessage instanceof ResponsedSelectLocation) {
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                eVar2 = this.cyx.aHD;
                eVar2.eP(false);
                eVar3 = this.cyx.aHD;
                eVar3.aX(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                bVar2 = this.cyx.cye;
                bVar2.B(2, responsedSelectLocation.getName());
                return;
            }
            eVar = this.cyx.aHD;
            eVar.eP(true);
            bVar = this.cyx.cye;
            bVar.setLocationInfoViewState(0);
        }
    }
}
