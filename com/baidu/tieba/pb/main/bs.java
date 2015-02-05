package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ bq bCJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(bq bqVar, int i, int i2) {
        super(i, i2);
        this.bCJ = bqVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        bt btVar;
        bt btVar2;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        int i2 = 0;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.bCJ.getUniqueId()) {
            if (responsedMessage.hasError()) {
                if (UtilHelper.isNetOk()) {
                    pbActivity2 = this.bCJ.bCF;
                    pbActivity2.showToast(responsedMessage.getErrorString());
                }
                if (responsedMessage.getError() == 4) {
                    pbActivity = this.bCJ.bCF;
                    pbActivity.finish();
                }
                z = false;
            } else {
                z = true;
            }
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.bCJ.a(pbpagesocketresponsemessage);
                i = pbpagesocketresponsemessage.getDownSize();
            } else {
                i = 0;
            }
            if (responsedMessage instanceof pbPageHttpResponseMessage) {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.bCJ.a(pbpagehttpresponsemessage);
                i2 = pbpagehttpresponsemessage.getDownSize();
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = this.bCJ.bCG;
            if (!z3) {
                this.bCJ.bCG = true;
                com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
                wVar.dX(1001);
                wVar.agV = z2;
                wVar.isSuccess = z;
                wVar.agK = responsedMessage.performanceData.fb;
                wVar.agL = responsedMessage.performanceData.fc;
                wVar.agM = responsedMessage.performanceData.fd;
                wVar.agN = responsedMessage.performanceData.fe;
                wVar.agO = responsedMessage.performanceData.ff;
                wVar.agT = i;
                wVar.agU = i2;
                btVar = this.bCJ.bCB;
                if (btVar != null) {
                    btVar2 = this.bCJ.bCB;
                    btVar2.e(wVar);
                }
            }
        }
    }
}
