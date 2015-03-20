package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ bq bJu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bt(bq bqVar, int i, int i2) {
        super(i, i2);
        this.bJu = bqVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        bu buVar;
        bu buVar2;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        int i2 = 0;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.bJu.getUniqueId()) {
            if (responsedMessage.hasError()) {
                if (UtilHelper.isNetOk()) {
                    pbActivity2 = this.bJu.bIF;
                    pbActivity2.showToast(responsedMessage.getErrorString());
                }
                if (responsedMessage.getError() == 4) {
                    pbActivity = this.bJu.bIF;
                    pbActivity.finish();
                }
                z = false;
            } else {
                z = true;
            }
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.bJu.a(pbpagesocketresponsemessage);
                i = pbpagesocketresponsemessage.getDownSize();
            } else {
                i = 0;
            }
            if (responsedMessage instanceof pbPageHttpResponseMessage) {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.bJu.a(pbpagehttpresponsemessage);
                i2 = pbpagehttpresponsemessage.getDownSize();
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = this.bJu.bJr;
            if (!z3) {
                this.bJu.bJr = true;
                com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
                aaVar.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                aaVar.apz = z2;
                aaVar.isSuccess = z;
                aaVar.apn = responsedMessage.performanceData.qt;
                aaVar.apo = responsedMessage.performanceData.qu;
                aaVar.apq = responsedMessage.performanceData.qv;
                aaVar.apr = responsedMessage.performanceData.qw;
                aaVar.aps = responsedMessage.performanceData.qx;
                aaVar.apx = i;
                aaVar.apy = i2;
                buVar = this.bJu.bJn;
                if (buVar != null) {
                    buVar2 = this.bJu.bJn;
                    buVar2.e(aaVar);
                }
            }
        }
    }
}
