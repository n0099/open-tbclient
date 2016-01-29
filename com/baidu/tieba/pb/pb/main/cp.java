package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.pb.pb.main.cm;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ cm cPd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp(cm cmVar, int i, int i2) {
        super(i, i2);
        this.cPd = cmVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0169  */
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
        cm.c cVar;
        cm.c cVar2;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.cPd.getUniqueId()) {
            boolean z4 = true;
            if (responsedMessage.hasError()) {
                z4 = false;
                if (responsedMessage.getError() == 4) {
                    baseActivity2 = this.cPd.bdK;
                    baseActivity2.showToast(responsedMessage.getErrorString());
                    z = false;
                    if (responsedMessage instanceof pbPageSocketResponseMessage) {
                        i = 0;
                    } else {
                        pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                        this.cPd.a(pbpagesocketresponsemessage);
                        i = pbpagesocketresponsemessage.getDownSize();
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        i2 = 0;
                        z2 = false;
                    } else {
                        pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                        this.cPd.a(pbpagehttpresponsemessage);
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
                    z3 = this.cPd.cOS;
                    if (z3) {
                        this.cPd.cOS = true;
                        com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
                        vVar.eZ(this.cPd.apM());
                        vVar.aAQ = z2;
                        vVar.isSuccess = z;
                        vVar.aAF = responsedMessage.performanceData.qD;
                        vVar.aAG = responsedMessage.performanceData.qE;
                        vVar.aAH = responsedMessage.performanceData.qF;
                        vVar.aAI = responsedMessage.performanceData.qG;
                        vVar.aAJ = responsedMessage.performanceData.qH;
                        vVar.aAO = i;
                        vVar.aAP = i2;
                        vVar.socketErrNo = responsedMessage.performanceData.qI;
                        vVar.socketCostTime = responsedMessage.performanceData.qJ;
                        vVar.errCode = responsedMessage.getError();
                        cVar = this.cPd.cOL;
                        if (cVar != null) {
                            cVar2 = this.cPd.cOL;
                            cVar2.e(vVar);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (com.baidu.adp.lib.util.i.iZ()) {
                    baseActivity = this.cPd.bdK;
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
            z3 = this.cPd.cOS;
            if (z3) {
            }
        }
    }
}
