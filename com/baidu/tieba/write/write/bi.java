package com.baidu.tieba.write.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class bi extends CustomMessageListener {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi(WriteActivity writeActivity, int i) {
        super(i);
        this.fSV = writeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LocationModel locationModel;
        LocationModel locationModel2;
        LocationModel locationModel3;
        if (customResponsedMessage instanceof ResponsedSelectLocation) {
            ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
            if (responsedSelectLocation.isShowLocation()) {
                locationModel2 = this.fSV.aAO;
                locationModel2.la(false);
                locationModel3 = this.fSV.aAO;
                locationModel3.cd(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                this.fSV.b(2, true, responsedSelectLocation.getName());
                return;
            }
            locationModel = this.fSV.aAO;
            locationModel.la(true);
            this.fSV.b(0, true, null);
        }
    }
}
