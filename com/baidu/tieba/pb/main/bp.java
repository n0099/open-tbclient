package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ bn bwU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp(bn bnVar, int i, int i2) {
        super(i, i2);
        this.bwU = bnVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        bq bqVar;
        bq bqVar2;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        int i2 = 0;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.bwU.getUniqueId()) {
            if (responsedMessage.hasError()) {
                if (UtilHelper.isNetOk()) {
                    pbActivity2 = this.bwU.bwQ;
                    pbActivity2.showToast(responsedMessage.getErrorString());
                }
                if (responsedMessage.getError() == 4) {
                    pbActivity = this.bwU.bwQ;
                    pbActivity.finish();
                }
                z = false;
            } else {
                z = true;
            }
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.bwU.a(pbpagesocketresponsemessage);
                i = pbpagesocketresponsemessage.getDownSize();
            } else {
                i = 0;
            }
            if (responsedMessage instanceof pbPageHttpResponseMessage) {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.bwU.a(pbpagehttpresponsemessage);
                i2 = pbpagehttpresponsemessage.getDownSize();
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = this.bwU.bwR;
            if (!z3) {
                this.bwU.bwR = true;
                com.baidu.tbadk.performanceLog.p pVar = new com.baidu.tbadk.performanceLog.p();
                pVar.dm(1001);
                pVar.Zh = z2;
                pVar.isSuccess = z;
                pVar.YW = responsedMessage.performanceData.cT;
                pVar.YX = responsedMessage.performanceData.cU;
                pVar.YY = responsedMessage.performanceData.cV;
                pVar.YZ = responsedMessage.performanceData.cW;
                pVar.Za = responsedMessage.performanceData.cX;
                pVar.Zf = i;
                pVar.Zg = i2;
                bqVar = this.bwU.bwM;
                if (bqVar != null) {
                    bqVar2 = this.bwU.bwM;
                    bqVar2.e(pVar);
                }
            }
        }
    }
}
