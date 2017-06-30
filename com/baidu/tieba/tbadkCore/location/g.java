package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ LocationModel fOq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LocationModel locationModel, int i) {
        super(i);
        this.fOq = locationModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LocationModel.b bVar;
        LocationModel.b bVar2;
        LocationModel.b bVar3;
        LocationModel.b bVar4;
        if (customResponsedMessage instanceof ResponsedSelectLocation) {
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                this.fOq.lU(false);
                this.fOq.ch(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                bVar3 = this.fOq.fOl;
                if (bVar3 != null) {
                    bVar4 = this.fOq.fOl;
                    bVar4.fR(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.fOq.lU(true);
            bVar = this.fOq.fOl;
            if (bVar != null) {
                bVar2 = this.fOq.fOl;
                bVar2.Dy();
            }
        }
    }
}
