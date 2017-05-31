package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ei extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbModel eqh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ei(PbModel pbModel, int i, int i2) {
        super(i, i2);
        this.eqh = pbModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        boolean z2;
        boolean z3;
        PbModel.a aVar;
        PbModel.a aVar2;
        boolean z4;
        long j;
        boolean z5;
        long j2;
        BaseActivity baseActivity;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.eqh.getUniqueId()) {
            if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.i.hk()) {
                baseActivity = this.eqh.bfa;
                baseActivity.showToast(responsedMessage.getErrorString());
            }
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.eqh.a(pbpagesocketresponsemessage);
                pbpagesocketresponsemessage.getDownSize();
            }
            if (!(responsedMessage instanceof pbPageHttpResponseMessage)) {
                z = false;
            } else {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.eqh.a(pbpagehttpresponsemessage);
                pbpagehttpresponsemessage.getDownSize();
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
                com.baidu.tbadk.core.e.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
            }
            z2 = this.eqh.epJ;
            if (z2) {
                z5 = this.eqh.epK;
                if (z5) {
                    return;
                }
            }
            z3 = this.eqh.epJ;
            if (!z3) {
                this.eqh.epJ = true;
            } else {
                this.eqh.epK = true;
            }
            aVar = this.eqh.epD;
            if (aVar != null) {
                aVar2 = this.eqh.epD;
                int aKK = this.eqh.aKK();
                z4 = this.eqh.epL;
                long currentTimeMillis = System.currentTimeMillis();
                j = this.eqh.cdX;
                aVar2.a(aKK, z, responsedMessage, z4, currentTimeMillis - j);
            }
        }
    }
}
