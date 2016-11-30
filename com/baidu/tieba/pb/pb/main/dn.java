package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.pb.pb.main.dj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ dj exP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn(dj djVar, int i, int i2) {
        super(i, i2);
        this.exP = djVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        boolean z;
        boolean z2;
        boolean z3;
        dj.a aVar;
        dj.a aVar2;
        boolean z4;
        long j;
        boolean z5;
        long j2;
        BaseActivity baseActivity;
        if (((responsedMessage instanceof pbPageSocketResponseMessage) || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.exP.getUniqueId()) {
            if (responsedMessage.hasError() && responsedMessage.getError() != 4 && com.baidu.adp.lib.util.i.gm()) {
                baseActivity = this.exP.aTb;
                baseActivity.showToast(responsedMessage.getErrorString());
            }
            if (responsedMessage instanceof pbPageSocketResponseMessage) {
                pbPageSocketResponseMessage pbpagesocketresponsemessage = (pbPageSocketResponseMessage) responsedMessage;
                this.exP.a(pbpagesocketresponsemessage);
                pbpagesocketresponsemessage.getDownSize();
            }
            if (!(responsedMessage instanceof pbPageHttpResponseMessage)) {
                z = false;
            } else {
                pbPageHttpResponseMessage pbpagehttpresponsemessage = (pbPageHttpResponseMessage) responsedMessage;
                this.exP.a(pbpagehttpresponsemessage);
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
                com.baidu.tbadk.core.log.b.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
            }
            z2 = this.exP.exz;
            if (z2) {
                z5 = this.exP.exA;
                if (z5) {
                    return;
                }
            }
            z3 = this.exP.exz;
            if (!z3) {
                this.exP.exz = true;
            } else {
                this.exP.exA = true;
            }
            aVar = this.exP.exs;
            if (aVar != null) {
                aVar2 = this.exP.exs;
                int aQm = this.exP.aQm();
                z4 = this.exP.exB;
                long currentTimeMillis = System.currentTimeMillis();
                j = this.exP.cfZ;
                aVar2.a(aQm, z, responsedMessage, z4, currentTimeMillis - j);
            }
        }
    }
}
