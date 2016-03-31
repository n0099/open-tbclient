package com.baidu.tieba.write.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class bf extends CustomMessageListener {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(WriteActivity writeActivity, int i) {
        super(i);
        this.eNd = writeActivity;
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
                dVar2 = this.eNd.avu;
                dVar2.iL(false);
                dVar3 = this.eNd.avu;
                dVar3.bH(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                this.eNd.a(2, true, responsedSelectLocation.getName());
                return;
            }
            dVar = this.eNd.avu;
            dVar.iL(true);
            this.eNd.a(0, true, (String) null);
        }
    }
}
