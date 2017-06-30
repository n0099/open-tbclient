package com.baidu.tieba.write.video;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ WriteLocationView gij;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(WriteLocationView writeLocationView, int i) {
        super(i);
        this.gij = writeLocationView;
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
                locationModel2 = this.gij.aBD;
                locationModel2.lU(false);
                locationModel3 = this.gij.aBD;
                locationModel3.ch(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                this.gij.c(2, true, responsedSelectLocation.getName());
                return;
            }
            locationModel = this.gij.aBD;
            locationModel.lU(true);
            this.gij.c(0, true, null);
        }
    }
}
