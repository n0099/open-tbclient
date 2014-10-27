package com.baidu.tieba.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.data.ar;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ e bAh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, int i2) {
        super(i, i2);
        this.bAh = eVar;
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
        bdUniqueId = this.bAh.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.bAh.isLoading = false;
            if (responsedMessage.hasError()) {
                this.bAh.bvu.showToast(responsedMessage.getErrorString());
                if (responsedMessage.getError() == 4) {
                    this.bAh.bvu.finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.bAh.b(subPbHttpResponseMessage.pbFloorData);
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
                        this.bAh.b(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.bAh.bAe;
            if (arrayList != null) {
                arrayList2 = this.bAh.bAe;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.bAh.bAe;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.bAh.bAe;
                            this.bAh.bpm.b((ar) arrayList5.get(size), true);
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.bAh.bAe;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            aVar = this.bAh.aAE;
            if (aVar == null) {
                this.bAh.aAE = new com.baidu.tieba.b.a("pbfloorStat");
            }
            aVar2 = this.bAh.aAE;
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
                    aVar3 = this.bAh.aAE;
                    aVar3.a(z, true, error, errorString, i, j3, j2);
                    this.bAh.aAE = new com.baidu.tieba.b.a("pbfloorStat");
                    this.bAh.aAE = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    if (this.bAh.bAb != null) {
                        this.bAh.bAb.a(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        arVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        arVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (arVar.Ar().errorno.intValue() != 0) {
                        if (this.bAh.bAb != null) {
                            this.bAh.bAb.a(false, arVar.amD.errorno.intValue(), arVar.amD.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (arVar.Ay() != null && arVar.Ay().getAuthor() != null) {
                        str = arVar.Ay().getAuthor().getUserId();
                    }
                    for (int i2 = 0; i2 < arVar.Au().size(); i2++) {
                        arVar.Au().get(i2).a(this.bAh.bvu, str.equals(arVar.Au().get(i2).getAuthor().getUserId()));
                    }
                    if (arVar.As() != null) {
                        this.bAh.alT = arVar.As().getId();
                    }
                    if (arVar.Ay() != null) {
                        this.bAh.bAa = arVar.Ay().getId();
                    }
                    if (this.bAh.auI == 1) {
                        this.bAh.bpm = arVar;
                    } else if (this.bAh.auI == 2) {
                        this.bAh.bpm.b(arVar, true);
                    } else if (this.bAh.auI == 3) {
                        this.bAh.bpm.a(arVar, false);
                    } else {
                        this.bAh.bpm.b(arVar, false);
                    }
                    if (this.bAh.bAb != null) {
                        this.bAh.bAb.a(true, error, errorString, this.bAh.bpm);
                    }
                }
            }
        }
    }
}
