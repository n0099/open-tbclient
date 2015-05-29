package com.baidu.tieba.write.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class bo extends CustomMessageListener {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(WriteActivity writeActivity, int i) {
        super(i);
        this.cCP = writeActivity;
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
                eVar2 = this.cCP.aJM;
                eVar2.fi(false);
                eVar3 = this.cCP.aJM;
                eVar3.bc(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                bVar2 = this.cCP.cCw;
                bVar2.D(2, responsedSelectLocation.getName());
                return;
            }
            eVar = this.cCP.aJM;
            eVar.fi(true);
            bVar = this.cCP.cCw;
            bVar.setLocationInfoViewState(0);
        }
    }
}
