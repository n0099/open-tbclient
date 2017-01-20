package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ LocationModel frN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(LocationModel locationModel, int i, boolean z) {
        super(i, z);
        this.frN = locationModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        LocationModel.a aVar;
        LocationModel.a aVar2;
        if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
            BdLog.i("mLocationListener response error!");
            aVar = this.frN.frH;
            if (aVar != null) {
                String str = null;
                if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                    str = socketResponsedMessage.getErrorString();
                }
                aVar2 = this.frN.frH;
                aVar2.fG(str);
                return;
            }
            return;
        }
        this.frN.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
    }
}
