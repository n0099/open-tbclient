package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.pb.pb.main.PbModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbModel eme;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dm(PbModel pbModel, int i, int i2) {
        super(i, i2);
        this.eme = pbModel;
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
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.eme.getUniqueId()) {
            if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.i.hj()) {
                baseActivity = this.eme.bcy;
                baseActivity.showToast(responsedMessage.getErrorString());
            }
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.eme.a(pbpagesocketresponsemessage);
                pbpagesocketresponsemessage.getDownSize();
            }
            if (!(responsedMessage instanceof pbPageHttpResponseMessage)) {
                z = false;
            } else {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.eme.a(pbpagehttpresponsemessage);
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
            z2 = this.eme.elL;
            if (z2) {
                z5 = this.eme.elM;
                if (z5) {
                    return;
                }
            }
            z3 = this.eme.elL;
            if (!z3) {
                this.eme.elL = true;
            } else {
                this.eme.elM = true;
            }
            aVar = this.eme.elF;
            if (aVar != null) {
                aVar2 = this.eme.elF;
                int aLz = this.eme.aLz();
                z4 = this.eme.elN;
                long currentTimeMillis = System.currentTimeMillis();
                j = this.eme.bXF;
                aVar2.a(aLz, z, responsedMessage, z4, currentTimeMillis - j);
            }
        }
    }
}
