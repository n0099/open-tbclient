package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ br bJJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu(br brVar, int i, int i2) {
        super(i, i2);
        this.bJJ = brVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        bv bvVar;
        bv bvVar2;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        int i2 = 0;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.bJJ.getUniqueId()) {
            if (responsedMessage.hasError()) {
                if (UtilHelper.isNetOk()) {
                    pbActivity2 = this.bJJ.bIT;
                    pbActivity2.showToast(responsedMessage.getErrorString());
                }
                if (responsedMessage.getError() == 4) {
                    pbActivity = this.bJJ.bIT;
                    pbActivity.finish();
                }
                z = false;
            } else {
                z = true;
            }
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.bJJ.a(pbpagesocketresponsemessage);
                i = pbpagesocketresponsemessage.getDownSize();
            } else {
                i = 0;
            }
            if (responsedMessage instanceof pbPageHttpResponseMessage) {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.bJJ.a(pbpagehttpresponsemessage);
                i2 = pbpagehttpresponsemessage.getDownSize();
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = this.bJJ.bJG;
            if (!z3) {
                this.bJJ.bJG = true;
                com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
                aaVar.eb(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                aaVar.apH = z2;
                aaVar.isSuccess = z;
                aaVar.apw = responsedMessage.performanceData.qt;
                aaVar.apx = responsedMessage.performanceData.qu;
                aaVar.apy = responsedMessage.performanceData.qv;
                aaVar.apz = responsedMessage.performanceData.qw;
                aaVar.apA = responsedMessage.performanceData.qx;
                aaVar.apF = i;
                aaVar.apG = i2;
                bvVar = this.bJJ.bJC;
                if (bvVar != null) {
                    bvVar2 = this.bJJ.bJC;
                    bvVar2.e(aaVar);
                }
            }
        }
    }
}
