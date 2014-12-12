package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ bq bBa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(bq bqVar, int i, int i2) {
        super(i, i2);
        this.bBa = bqVar;
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
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.bBa.getUniqueId()) {
            if (responsedMessage.hasError()) {
                if (UtilHelper.isNetOk()) {
                    pbActivity2 = this.bBa.bAW;
                    pbActivity2.showToast(responsedMessage.getErrorString());
                }
                if (responsedMessage.getError() == 4) {
                    pbActivity = this.bBa.bAW;
                    pbActivity.finish();
                }
                z = false;
            } else {
                z = true;
            }
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.bBa.a(pbpagesocketresponsemessage);
                i = pbpagesocketresponsemessage.getDownSize();
            } else {
                i = 0;
            }
            if (responsedMessage instanceof pbPageHttpResponseMessage) {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.bBa.a(pbpagehttpresponsemessage);
                i2 = pbpagehttpresponsemessage.getDownSize();
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = this.bBa.bAX;
            if (!z3) {
                this.bBa.bAX = true;
                com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
                wVar.dR(1001);
                wVar.agA = z2;
                wVar.isSuccess = z;
                wVar.agp = responsedMessage.performanceData.eZ;
                wVar.agq = responsedMessage.performanceData.fa;
                wVar.agr = responsedMessage.performanceData.fb;
                wVar.ags = responsedMessage.performanceData.fc;
                wVar.agt = responsedMessage.performanceData.fd;
                wVar.agy = i;
                wVar.agz = i2;
                btVar = this.bBa.bAS;
                if (btVar != null) {
                    btVar2 = this.bBa.bAS;
                    btVar2.e(wVar);
                }
            }
        }
    }
}
