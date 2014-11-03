package com.baidu.tieba.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.data.ar;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ e bAv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, int i2) {
        super(i, i2);
        this.bAv = eVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.b.a aVar;
        com.baidu.tieba.b.a aVar2;
        ar arVar;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.b.a aVar3;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        long j4 = 0;
        String str = null;
        bdUniqueId = this.bAv.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.bAv.isLoading = false;
            if (responsedMessage.hasError()) {
                this.bAv.bvI.showToast(responsedMessage.getErrorString());
                if (responsedMessage.getError() == 4) {
                    this.bAv.bvI.finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.bAv.b(subPbHttpResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
                j = costTime;
                z = true;
            } else {
                j = 0;
                z = false;
            }
            if (responsedMessage instanceof SubPbSocketResponseMessage) {
                ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                j4 = responsedMessage.getCostTime();
                SubPbSocketResponseMessage subPbSocketResponseMessage = (SubPbSocketResponseMessage) responsedMessage;
                if (subPbSocketResponseMessage.isTreatDelPage()) {
                    if (!subPbSocketResponseMessage.hasError()) {
                        this.bAv.b(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.bAv.bAs;
            if (arrayList != null) {
                arrayList2 = this.bAv.bAs;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.bAv.bAs;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.bAv.bAs;
                            this.bAv.bpA.b((ar) arrayList5.get(size), true);
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.bAv.bAs;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            aVar = this.bAv.aAO;
            if (aVar == null) {
                this.bAv.aAO = new com.baidu.tieba.b.a("pbfloorStat");
            }
            aVar2 = this.bAv.aAO;
            if (aVar2 != null) {
                if (error == 0) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        int downSize = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        j2 = j4;
                        j3 = responsedMessage.getCostTime();
                        i = downSize;
                    } else if (!(responsedMessage instanceof SubPbSocketResponseMessage)) {
                        j2 = j4;
                        j3 = j;
                        i = -1;
                    } else {
                        int downSize2 = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                        j2 = responsedMessage.getCostTime();
                        j3 = j;
                        i = downSize2;
                    }
                    aVar3 = this.bAv.aAO;
                    aVar3.a(z, true, error, errorString, i, j3, j2);
                    this.bAv.aAO = new com.baidu.tieba.b.a("pbfloorStat");
                    this.bAv.aAO = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    if (this.bAv.bAp != null) {
                        this.bAv.bAp.a(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        arVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        arVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (arVar.At().errorno.intValue() != 0) {
                        if (this.bAv.bAp != null) {
                            this.bAv.bAp.a(false, arVar.amM.errorno.intValue(), arVar.amM.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (arVar.AA() != null && arVar.AA().getAuthor() != null) {
                        str = arVar.AA().getAuthor().getUserId();
                    }
                    for (int i2 = 0; i2 < arVar.Aw().size(); i2++) {
                        arVar.Aw().get(i2).a(this.bAv.bvI, str.equals(arVar.Aw().get(i2).getAuthor().getUserId()));
                    }
                    if (arVar.Au() != null) {
                        this.bAv.amc = arVar.Au().getId();
                    }
                    if (arVar.AA() != null) {
                        this.bAv.bAo = arVar.AA().getId();
                    }
                    if (this.bAv.auR == 1) {
                        this.bAv.bpA = arVar;
                    } else if (this.bAv.auR == 2) {
                        this.bAv.bpA.b(arVar, true);
                    } else if (this.bAv.auR == 3) {
                        this.bAv.bpA.a(arVar, false);
                    } else {
                        this.bAv.bpA.b(arVar, false);
                    }
                    if (this.bAv.bAp != null) {
                        this.bAv.bAp.a(true, error, errorString, this.bAv.bpA);
                    }
                }
            }
        }
    }
}
