package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ bn bxi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp(bn bnVar, int i, int i2) {
        super(i, i2);
        this.bxi = bnVar;
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
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.bxi.getUniqueId()) {
            if (responsedMessage.hasError()) {
                if (UtilHelper.isNetOk()) {
                    pbActivity2 = this.bxi.bxe;
                    pbActivity2.showToast(responsedMessage.getErrorString());
                }
                if (responsedMessage.getError() == 4) {
                    pbActivity = this.bxi.bxe;
                    pbActivity.finish();
                }
                z = false;
            } else {
                z = true;
            }
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.bxi.a(pbpagesocketresponsemessage);
                i = pbpagesocketresponsemessage.getDownSize();
            } else {
                i = 0;
            }
            if (responsedMessage instanceof pbPageHttpResponseMessage) {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.bxi.a(pbpagehttpresponsemessage);
                i2 = pbpagehttpresponsemessage.getDownSize();
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = this.bxi.bxf;
            if (!z3) {
                this.bxi.bxf = true;
                com.baidu.tbadk.performanceLog.p pVar = new com.baidu.tbadk.performanceLog.p();
                pVar.dm(1001);
                pVar.Zl = z2;
                pVar.isSuccess = z;
                pVar.Za = responsedMessage.performanceData.cT;
                pVar.Zb = responsedMessage.performanceData.cU;
                pVar.Zc = responsedMessage.performanceData.cV;
                pVar.Zd = responsedMessage.performanceData.cW;
                pVar.Ze = responsedMessage.performanceData.cX;
                pVar.Zj = i;
                pVar.Zk = i2;
                bqVar = this.bxi.bxa;
                if (bqVar != null) {
                    bqVar2 = this.bxi.bxa;
                    bqVar2.e(pVar);
                }
            }
        }
    }
}
