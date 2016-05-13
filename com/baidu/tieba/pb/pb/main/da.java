package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.pb.pb.main.cw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ cw dlN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public da(cw cwVar, int i, int i2) {
        super(i, i2);
        this.dlN = cwVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        cw.a aVar;
        cw.a aVar2;
        long j;
        boolean z5;
        long j2;
        BaseActivity baseActivity;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.dlN.getUniqueId()) {
            boolean z6 = true;
            if (responsedMessage.hasError()) {
                z6 = false;
                if (responsedMessage.getError() != 4 && com.baidu.adp.lib.util.i.fq()) {
                    baseActivity = this.dlN.bek;
                    baseActivity.showToast(responsedMessage.getErrorString());
                }
            }
            boolean z7 = z6;
            if (!(responsedMessage instanceof pbPageSocketResponseMessage)) {
                i = 0;
            } else {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.dlN.a(pbpagesocketresponsemessage);
                i = pbpagesocketresponsemessage.getDownSize();
            }
            if (!(responsedMessage instanceof pbPageHttpResponseMessage)) {
                i2 = 0;
                z = false;
            } else {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.dlN.a(pbpagehttpresponsemessage);
                i2 = pbpagehttpresponsemessage.getDownSize();
                z = true;
            }
            if (responsedMessage.getError() != 0) {
                if (z) {
                    j2 = 0;
                } else {
                    j2 = ((pbPageSocketResponseMessage) responsedMessage).sequenceID;
                }
                PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
                long clientLogID = responsedMessage.getOrginalMessage().getClientLogID();
                int cmd = responsedMessage.getOrginalMessage().getCmd();
                int error = responsedMessage.getError();
                String errorString = responsedMessage.getErrorString();
                Object[] objArr = new Object[6];
                objArr[0] = "updateType";
                objArr[1] = pbPageRequestMessage != null ? String.valueOf(pbPageRequestMessage.getUpdateType()) : null;
                objArr[2] = "ThreadId";
                objArr[3] = pbPageRequestMessage != null ? String.valueOf(pbPageRequestMessage.get_kz()) : null;
                objArr[4] = "seq_id";
                objArr[5] = Long.valueOf(j2);
                com.baidu.tbadk.core.log.b.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
            }
            z2 = this.dlN.dlx;
            if (z2) {
                z5 = this.dlN.dly;
                if (z5) {
                    return;
                }
            }
            z3 = this.dlN.dlx;
            if (!z3) {
                this.dlN.dlx = true;
            } else {
                this.dlN.dly = true;
            }
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.eL(this.dlN.axB());
            vVar.axK = z;
            vVar.isSuccess = z7;
            vVar.axy = responsedMessage.performanceData.gv;
            vVar.axz = responsedMessage.performanceData.gw;
            vVar.axA = responsedMessage.performanceData.gx;
            vVar.eD = responsedMessage.performanceData.gy;
            vVar.eE = responsedMessage.performanceData.gz;
            vVar.axB = responsedMessage.performanceData.gA;
            vVar.axC = responsedMessage.performanceData.gB;
            vVar.axD = responsedMessage.performanceData.gC;
            vVar.axD += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            vVar.axL = responsedMessage.performanceData.gF;
            vVar.axM = responsedMessage.performanceData.gG;
            vVar.axI = i;
            vVar.axJ = i2;
            vVar.socketErrNo = responsedMessage.performanceData.gD;
            vVar.socketCostTime = responsedMessage.performanceData.gE;
            vVar.errCode = responsedMessage.getError();
            z4 = this.dlN.dlz;
            if (z4) {
                long currentTimeMillis = System.currentTimeMillis();
                j = this.dlN.bsa;
                vVar.axF = currentTimeMillis - j;
                vVar.axN = true;
            }
            if (z) {
                vVar.axO = responsedMessage.getOrginalMessage().getClientLogID();
            } else {
                vVar.sequenceID = ((pbPageSocketResponseMessage) responsedMessage).sequenceID;
            }
            aVar = this.dlN.dlr;
            if (aVar != null) {
                aVar2 = this.dlN.dlr;
                aVar2.d(vVar);
            }
        }
    }
}
