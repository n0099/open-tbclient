package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ LocationModel fxU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(LocationModel locationModel, int i, boolean z) {
        super(i, z);
        this.fxU = locationModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        LocationModel.a aVar;
        LocationModel.a aVar2;
        if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
            BdLog.i("mLocationListener response error!");
            aVar = this.fxU.fxO;
            if (aVar != null) {
                String str = null;
                if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                    str = socketResponsedMessage.getErrorString();
                }
                aVar2 = this.fxU.fxO;
                aVar2.fB(str);
                return;
            }
            return;
        }
        this.fxU.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
    }
}
