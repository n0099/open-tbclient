package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.pb.pb.main.df;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ df dju;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(df dfVar, int i, int i2) {
        super(i, i2);
        this.dju = dfVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        df.c cVar;
        df.c cVar2;
        long j;
        boolean z5;
        long j2;
        BaseActivity baseActivity;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.dju.getUniqueId()) {
            boolean z6 = true;
            if (responsedMessage.hasError()) {
                z6 = false;
                if (responsedMessage.getError() != 4 && com.baidu.adp.lib.util.i.jf()) {
                    baseActivity = this.dju.bix;
                    baseActivity.showToast(responsedMessage.getErrorString());
                }
            }
            boolean z7 = z6;
            if (!(responsedMessage instanceof pbPageSocketResponseMessage)) {
                i = 0;
            } else {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.dju.a(pbpagesocketresponsemessage);
                i = pbpagesocketresponsemessage.getDownSize();
            }
            if (!(responsedMessage instanceof pbPageHttpResponseMessage)) {
                i2 = 0;
                z = false;
            } else {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.dju.a(pbpagehttpresponsemessage);
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
            z2 = this.dju.dje;
            if (z2) {
                z5 = this.dju.djf;
                if (z5) {
                    return;
                }
            }
            z3 = this.dju.dje;
            if (!z3) {
                this.dju.dje = true;
            } else {
                this.dju.djf = true;
            }
            com.baidu.tbadk.performanceLog.v vVar = new com.baidu.tbadk.performanceLog.v();
            vVar.fh(this.dju.axb());
            vVar.aBH = z;
            vVar.isSuccess = z7;
            vVar.aBv = responsedMessage.performanceData.qH;
            vVar.aBw = responsedMessage.performanceData.qI;
            vVar.aBx = responsedMessage.performanceData.qJ;
            vVar.oL = responsedMessage.performanceData.qK;
            vVar.oM = responsedMessage.performanceData.qL;
            vVar.aBy = responsedMessage.performanceData.qM;
            vVar.aBz = responsedMessage.performanceData.qN;
            vVar.aBA = responsedMessage.performanceData.qO;
            vVar.aBA += responsedMessage.getProcessTime() - responsedMessage.getStartTime();
            vVar.aBI = responsedMessage.performanceData.qR;
            vVar.aBJ = responsedMessage.performanceData.qS;
            vVar.aBF = i;
            vVar.aBG = i2;
            vVar.socketErrNo = responsedMessage.performanceData.qP;
            vVar.socketCostTime = responsedMessage.performanceData.qQ;
            vVar.errCode = responsedMessage.getError();
            z4 = this.dju.djg;
            if (z4) {
                long currentTimeMillis = System.currentTimeMillis();
                j = this.dju.btk;
                vVar.aBC = currentTimeMillis - j;
                vVar.aBK = true;
            }
            if (z) {
                vVar.aBL = responsedMessage.getOrginalMessage().getClientLogID();
            } else {
                vVar.sequenceID = ((pbPageSocketResponseMessage) responsedMessage).sequenceID;
            }
            cVar = this.dju.diX;
            if (cVar != null) {
                cVar2 = this.dju.diX;
                cVar2.d(vVar);
            }
        }
    }
}
