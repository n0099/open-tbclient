package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ LocationModel fAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LocationModel locationModel, int i) {
        super(i);
        this.fAk = locationModel;
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
                this.fAk.lw(false);
                this.fAk.cd(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                bVar3 = this.fAk.fAf;
                if (bVar3 != null) {
                    bVar4 = this.fAk.fAf;
                    bVar4.fC(responsedSelectLocation.getName());
                    return;
                }
                return;
            }
            this.fAk.lw(true);
            bVar = this.fAk.fAf;
            if (bVar != null) {
                bVar2 = this.fAk.fAf;
                bVar2.Eg();
            }
        }
    }
}
