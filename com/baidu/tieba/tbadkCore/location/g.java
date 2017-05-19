package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ LocationModel fwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LocationModel locationModel, int i) {
        super(i);
        this.fwt = locationModel;
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
                this.fwt.la(false);
                this.fwt.cd(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                bVar3 = this.fwt.fwo;
                if (bVar3 != null) {
                    bVar4 = this.fwt.fwo;
                    bVar4.fz(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.fwt.la(true);
            bVar = this.fwt.fwo;
            if (bVar != null) {
                bVar2 = this.fwt.fwo;
                bVar2.Dk();
            }
        }
    }
}
