package com.baidu.tieba.write.video;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ WriteLocationView fRp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(WriteLocationView writeLocationView, int i) {
        super(i);
        this.fRp = writeLocationView;
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
                locationModel2 = this.fRp.aAQ;
                locationModel2.lw(false);
                locationModel3 = this.fRp.aAQ;
                locationModel3.cd(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                this.fRp.c(2, true, responsedSelectLocation.getName());
                return;
            }
            locationModel = this.fRp.aAQ;
            locationModel.lw(true);
            this.fRp.c(0, true, null);
        }
    }
}
