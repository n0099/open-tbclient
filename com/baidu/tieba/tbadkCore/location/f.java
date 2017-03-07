package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CustomMessageListener {
    final /* synthetic */ LocationModel fwk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(LocationModel locationModel, int i) {
        super(i);
        this.fwk = locationModel;
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
                this.fwk.lj(false);
                this.fwk.cd(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                bVar3 = this.fwk.fwf;
                if (bVar3 != null) {
                    bVar4 = this.fwk.fwf;
                    bVar4.fw(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.fwk.lj(true);
            bVar = this.fwk.fwf;
            if (bVar != null) {
                bVar2 = this.fwk.fwf;
                bVar2.DI();
            }
        }
    }
}
