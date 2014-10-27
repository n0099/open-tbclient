package com.baidu.tieba.location;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d blV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, boolean z) {
        super(i, z);
        this.blV = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        i iVar;
        i iVar2;
        if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
            BdLog.i("mLocationListener response error!");
            iVar = this.blV.blO;
            if (iVar != null) {
                String str = null;
                if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                    str = socketResponsedMessage.getErrorString();
                }
                iVar2 = this.blV.blO;
                iVar2.eY(str);
                return;
            }
            return;
        }
        this.blV.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
    }
}
