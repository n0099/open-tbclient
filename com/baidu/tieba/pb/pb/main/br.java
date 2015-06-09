package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ bo bLQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(bo boVar, int i, int i2) {
        super(i, i2);
        this.bLQ = boVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.adp.framework.listener.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        bs bsVar;
        bs bsVar2;
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.bLQ.getUniqueId()) {
            boolean z4 = true;
            if (responsedMessage.hasError()) {
                z4 = false;
                if (responsedMessage.getError() == 4) {
                    pbActivity2 = this.bLQ.bLa;
                    pbActivity2.showToast(responsedMessage.getErrorString());
                    z = false;
                    if (responsedMessage instanceof pbPageSocketResponseMessage) {
                        i = 0;
                    } else {
                        pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                        this.bLQ.a(pbpagesocketresponsemessage);
                        i = pbpagesocketresponsemessage.getDownSize();
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        i2 = 0;
                        z2 = false;
                    } else {
                        pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                        this.bLQ.a(pbpagehttpresponsemessage);
                        i2 = pbpagehttpresponsemessage.getDownSize();
                        z2 = true;
                    }
                    pbPageRequestMessage pbpagerequestmessage = (pbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
                    long clientLogID = responsedMessage.getOrginalMessage().getClientLogID();
                    int cmd = responsedMessage.getOrginalMessage().getCmd();
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    Object[] objArr = new Object[4];
                    objArr[0] = "updateType";
                    objArr[1] = pbpagerequestmessage == null ? String.valueOf(pbpagerequestmessage.getUpdateType()) : null;
                    objArr[2] = "ThreadId";
                    objArr[3] = pbpagerequestmessage == null ? String.valueOf(pbpagerequestmessage.get_kz()) : null;
                    com.baidu.tbadk.core.log.b.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    z3 = this.bLQ.bLN;
                    if (z3) {
                        this.bLQ.bLN = true;
                        com.baidu.tbadk.performanceLog.aa aaVar = new com.baidu.tbadk.performanceLog.aa();
                        aaVar.el(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        aaVar.aqJ = z2;
                        aaVar.isSuccess = z;
                        aaVar.aqy = responsedMessage.performanceData.qx;
                        aaVar.aqz = responsedMessage.performanceData.qy;
                        aaVar.aqA = responsedMessage.performanceData.qz;
                        aaVar.aqB = responsedMessage.performanceData.qA;
                        aaVar.aqC = responsedMessage.performanceData.qB;
                        aaVar.aqH = i;
                        aaVar.aqI = i2;
                        bsVar = this.bLQ.bLJ;
                        if (bsVar != null) {
                            bsVar2 = this.bLQ.bLJ;
                            bsVar2.e(aaVar);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (UtilHelper.isNetOk()) {
                    pbActivity = this.bLQ.bLa;
                    pbActivity.showToast(responsedMessage.getErrorString());
                }
            }
            z = z4;
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
            }
            if (responsedMessage instanceof pbPageHttpResponseMessage) {
            }
            pbPageRequestMessage pbpagerequestmessage2 = (pbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
            long clientLogID2 = responsedMessage.getOrginalMessage().getClientLogID();
            int cmd2 = responsedMessage.getOrginalMessage().getCmd();
            int error2 = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            Object[] objArr2 = new Object[4];
            objArr2[0] = "updateType";
            objArr2[1] = pbpagerequestmessage2 == null ? String.valueOf(pbpagerequestmessage2.getUpdateType()) : null;
            objArr2[2] = "ThreadId";
            objArr2[3] = pbpagerequestmessage2 == null ? String.valueOf(pbpagerequestmessage2.get_kz()) : null;
            com.baidu.tbadk.core.log.b.a("pb", clientLogID2, cmd2, "resp", error2, errorString2, objArr2);
            z3 = this.bLQ.bLN;
            if (z3) {
            }
        }
    }
}
