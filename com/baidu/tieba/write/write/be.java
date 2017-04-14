package com.baidu.tieba.write.write;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* loaded from: classes.dex */
class be extends CustomMessageListener {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public be(WriteActivity writeActivity, int i) {
        super(i);
        this.fSq = writeActivity;
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
                locationModel2 = this.fSq.aAO;
                locationModel2.lm(false);
                locationModel3 = this.fSq.aAO;
                locationModel3.ce(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                this.fSq.b(2, true, responsedSelectLocation.getName());
                return;
            }
            locationModel = this.fSq.aAO;
            locationModel.lm(true);
            this.fSq.b(0, true, null);
        }
    }
}
