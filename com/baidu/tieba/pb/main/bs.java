package com.baidu.tieba.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ bq bCK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(bq bqVar, int i, int i2) {
        super(i, i2);
        this.bCK = bqVar;
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
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.bCK.getUniqueId()) {
            if (responsedMessage.hasError()) {
                if (UtilHelper.isNetOk()) {
                    pbActivity2 = this.bCK.bCG;
                    pbActivity2.showToast(responsedMessage.getErrorString());
                }
                if (responsedMessage.getError() == 4) {
                    pbActivity = this.bCK.bCG;
                    pbActivity.finish();
                }
                z = false;
            } else {
                z = true;
            }
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.bCK.a(pbpagesocketresponsemessage);
                i = pbpagesocketresponsemessage.getDownSize();
            } else {
                i = 0;
            }
            if (responsedMessage instanceof pbPageHttpResponseMessage) {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.bCK.a(pbpagehttpresponsemessage);
                i2 = pbpagehttpresponsemessage.getDownSize();
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = this.bCK.bCH;
            if (!z3) {
                this.bCK.bCH = true;
                com.baidu.tbadk.performanceLog.w wVar = new com.baidu.tbadk.performanceLog.w();
                wVar.dX(1001);
                wVar.agY = z2;
                wVar.isSuccess = z;
                wVar.agN = responsedMessage.performanceData.fb;
                wVar.agO = responsedMessage.performanceData.fc;
                wVar.agP = responsedMessage.performanceData.fd;
                wVar.agQ = responsedMessage.performanceData.fe;
                wVar.agR = responsedMessage.performanceData.ff;
                wVar.agW = i;
                wVar.agX = i2;
                btVar = this.bCK.bCC;
                if (btVar != null) {
                    btVar2 = this.bCK.bCC;
                    btVar2.e(wVar);
                }
            }
        }
    }
}
