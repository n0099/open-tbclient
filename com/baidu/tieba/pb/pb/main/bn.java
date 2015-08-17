package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.pb.pb.main.bk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ bk ccq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(bk bkVar, int i, int i2) {
        super(i, i2);
        this.ccq = bkVar;
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
        bk.a aVar;
        bk.a aVar2;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if (((responsedMessage instanceof PbPageSocketResponseMessage) || (responsedMessage instanceof PbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.ccq.getUniqueId()) {
            boolean z4 = true;
            if (responsedMessage.hasError()) {
                z4 = false;
                if (responsedMessage.getError() == 4) {
                    baseActivity2 = this.ccq.aSJ;
                    baseActivity2.showToast(responsedMessage.getErrorString());
                    z = false;
                    if (responsedMessage instanceof PbPageSocketResponseMessage) {
                        i = 0;
                    } else {
                        PbPageSocketResponseMessage pbPageSocketResponseMessage = (PbPageSocketResponseMessage) responsedMessage;
                        this.ccq.a(pbPageSocketResponseMessage);
                        i = pbPageSocketResponseMessage.getDownSize();
                    }
                    if (responsedMessage instanceof PbPageHttpResponseMessage) {
                        i2 = 0;
                        z2 = false;
                    } else {
                        PbPageHttpResponseMessage pbPageHttpResponseMessage = (PbPageHttpResponseMessage) responsedMessage;
                        this.ccq.a(pbPageHttpResponseMessage);
                        i2 = pbPageHttpResponseMessage.getDownSize();
                        z2 = true;
                    }
                    PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
                    long clientLogID = responsedMessage.getOrginalMessage().getClientLogID();
                    int cmd = responsedMessage.getOrginalMessage().getCmd();
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    Object[] objArr = new Object[4];
                    objArr[0] = "updateType";
                    objArr[1] = pbPageRequestMessage == null ? String.valueOf(pbPageRequestMessage.getUpdateType()) : null;
                    objArr[2] = "ThreadId";
                    objArr[3] = pbPageRequestMessage == null ? String.valueOf(pbPageRequestMessage.get_kz()) : null;
                    com.baidu.tbadk.core.log.b.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    z3 = this.ccq.ccm;
                    if (z3) {
                        this.ccq.ccm = true;
                        com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
                        tVar.eq(BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES);
                        tVar.axw = z2;
                        tVar.isSuccess = z;
                        tVar.axl = responsedMessage.performanceData.qy;
                        tVar.axm = responsedMessage.performanceData.qz;
                        tVar.axn = responsedMessage.performanceData.qA;
                        tVar.axo = responsedMessage.performanceData.qB;
                        tVar.axp = responsedMessage.performanceData.qC;
                        tVar.axu = i;
                        tVar.axv = i2;
                        aVar = this.ccq.cci;
                        if (aVar != null) {
                            aVar2 = this.ccq.cci;
                            aVar2.e(tVar);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (com.baidu.adp.lib.util.i.iO()) {
                    baseActivity = this.ccq.aSJ;
                    baseActivity.showToast(responsedMessage.getErrorString());
                }
            }
            z = z4;
            if (responsedMessage instanceof PbPageSocketResponseMessage) {
            }
            if (responsedMessage instanceof PbPageHttpResponseMessage) {
            }
            PbPageRequestMessage pbPageRequestMessage2 = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
            long clientLogID2 = responsedMessage.getOrginalMessage().getClientLogID();
            int cmd2 = responsedMessage.getOrginalMessage().getCmd();
            int error2 = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            Object[] objArr2 = new Object[4];
            objArr2[0] = "updateType";
            objArr2[1] = pbPageRequestMessage2 == null ? String.valueOf(pbPageRequestMessage2.getUpdateType()) : null;
            objArr2[2] = "ThreadId";
            objArr2[3] = pbPageRequestMessage2 == null ? String.valueOf(pbPageRequestMessage2.get_kz()) : null;
            com.baidu.tbadk.core.log.b.a("pb", clientLogID2, cmd2, "resp", error2, errorString2, objArr2);
            z3 = this.ccq.ccm;
            if (z3) {
            }
        }
    }
}
