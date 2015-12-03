package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.pb.pb.main.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ cc cDC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cf(cc ccVar, int i, int i2) {
        super(i, i2);
        this.cDC = ccVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
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
        cc.b bVar;
        cc.b bVar2;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.cDC.getUniqueId()) {
            boolean z4 = true;
            if (responsedMessage.hasError()) {
                z4 = false;
                if (responsedMessage.getError() == 4) {
                    baseActivity2 = this.cDC.aXA;
                    baseActivity2.showToast(responsedMessage.getErrorString());
                    z = false;
                    if (responsedMessage instanceof pbPageSocketResponseMessage) {
                        i = 0;
                    } else {
                        pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                        this.cDC.a(pbpagesocketresponsemessage);
                        i = pbpagesocketresponsemessage.getDownSize();
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        i2 = 0;
                        z2 = false;
                    } else {
                        pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                        this.cDC.a(pbpagehttpresponsemessage);
                        i2 = pbpagehttpresponsemessage.getDownSize();
                        z2 = true;
                    }
                    if (responsedMessage.getError() != 0) {
                        PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
                        long clientLogID = responsedMessage.getOrginalMessage().getClientLogID();
                        int cmd = responsedMessage.getOrginalMessage().getCmd();
                        int error = responsedMessage.getError();
                        String errorString = responsedMessage.getErrorString();
                        Object[] objArr = new Object[4];
                        objArr[0] = "updateType";
                        objArr[1] = pbPageRequestMessage != null ? String.valueOf(pbPageRequestMessage.getUpdateType()) : null;
                        objArr[2] = "ThreadId";
                        objArr[3] = pbPageRequestMessage != null ? String.valueOf(pbPageRequestMessage.get_kz()) : null;
                        com.baidu.tbadk.core.log.b.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    z3 = this.cDC.cDt;
                    if (z3) {
                        this.cDC.cDt = true;
                        com.baidu.tbadk.performanceLog.t tVar = new com.baidu.tbadk.performanceLog.t();
                        tVar.eL(this.cDC.akC());
                        tVar.ayy = z2;
                        tVar.isSuccess = z;
                        tVar.ayn = responsedMessage.performanceData.qx;
                        tVar.ayo = responsedMessage.performanceData.qy;
                        tVar.ayp = responsedMessage.performanceData.qz;
                        tVar.ayq = responsedMessage.performanceData.qA;
                        tVar.ayr = responsedMessage.performanceData.qB;
                        tVar.ayw = i;
                        tVar.ayx = i2;
                        tVar.socketErrNo = responsedMessage.performanceData.qC;
                        tVar.errCode = responsedMessage.getError();
                        bVar = this.cDC.cDp;
                        if (bVar != null) {
                            bVar2 = this.cDC.cDp;
                            bVar2.e(tVar);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (com.baidu.adp.lib.util.i.iP()) {
                    baseActivity = this.cDC.aXA;
                    baseActivity.showToast(responsedMessage.getErrorString());
                }
            }
            z = z4;
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
            }
            if (responsedMessage instanceof pbPageHttpResponseMessage) {
            }
            if (responsedMessage.getError() != 0) {
            }
            z3 = this.cDC.cDt;
            if (z3) {
            }
        }
    }
}
