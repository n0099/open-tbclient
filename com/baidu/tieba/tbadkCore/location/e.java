package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d fEu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, int i, boolean z) {
        super(i, z);
        this.fEu = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        d.a aVar;
        d.a aVar2;
        if (socketResponsedMessage == null || socketResponsedMessage.getError() != 0 || !(socketResponsedMessage instanceof LocationSocketResponsedMessage)) {
            BdLog.i("mLocationListener response error!");
            aVar = this.fEu.fEn;
            if (aVar != null) {
                String str = null;
                if (socketResponsedMessage != null && socketResponsedMessage.getError() > 0) {
                    str = socketResponsedMessage.getErrorString();
                }
                aVar2 = this.fEu.fEn;
                aVar2.fN(str);
                return;
            }
            return;
        }
        this.fEu.c(((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData());
    }
}
