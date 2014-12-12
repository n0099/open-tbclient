package com.baidu.tieba.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ e bEi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, int i2) {
        super(i, i2);
        this.bEi = eVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: com.baidu.tieba.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.d.a aVar;
        com.baidu.tieba.tbadkCore.d.a aVar2;
        com.baidu.tieba.tbadkCore.b.o oVar;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.tbadkCore.d.a aVar3;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        long j4 = 0;
        String str = null;
        bdUniqueId = this.bEi.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.bEi.aef = false;
            if (responsedMessage.hasError()) {
                this.bEi.bEa.showToast(responsedMessage.getErrorString());
                if (responsedMessage.getError() == 4) {
                    this.bEi.bEa.finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.bEi.b(subPbHttpResponseMessage.pbFloorData);
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
                        this.bEi.b(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.bEi.bEf;
            if (arrayList != null) {
                arrayList2 = this.bEi.bEf;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.bEi.bEf;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.bEi.bEf;
                            this.bEi.bEb.b((com.baidu.tieba.tbadkCore.b.o) arrayList5.get(size), true);
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.bEi.bEf;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            aVar = this.bEi.aCg;
            if (aVar == null) {
                this.bEi.aCg = new com.baidu.tieba.tbadkCore.d.a("pbfloorStat");
            }
            aVar2 = this.bEi.aCg;
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
                    aVar3 = this.bEi.aCg;
                    aVar3.a(z, true, error, errorString, i, j3, j2);
                    this.bEi.aCg = new com.baidu.tieba.tbadkCore.d.a("pbfloorStat");
                    this.bEi.aCg = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    if (this.bEi.bEc != null) {
                        this.bEi.bEc.a(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        oVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        oVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (oVar.ahb().errorno.intValue() != 0) {
                        if (this.bEi.bEc != null) {
                            this.bEi.bEc.a(false, oVar.bXj.errorno.intValue(), oVar.bXj.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (oVar.ahh() != null && oVar.ahh().getAuthor() != null) {
                        str = oVar.ahh().getAuthor().getUserId();
                    }
                    for (int i2 = 0; i2 < oVar.ahe().size(); i2++) {
                        oVar.ahe().get(i2).a(this.bEi.bEa.getPageContext(), str.equals(oVar.ahe().get(i2).getAuthor().getUserId()));
                    }
                    if (oVar.ahc() != null) {
                        this.bEi.Bd = oVar.ahc().getId();
                    }
                    if (oVar.ahh() != null) {
                        this.bEi.bDZ = oVar.ahh().getId();
                    }
                    if (this.bEi.mLoadType == 1) {
                        this.bEi.bEb = oVar;
                    } else if (this.bEi.mLoadType == 2) {
                        this.bEi.bEb.b(oVar, true);
                    } else if (this.bEi.mLoadType == 3) {
                        this.bEi.bEb.a(oVar, false);
                    } else {
                        this.bEi.bEb.b(oVar, false);
                    }
                    if (this.bEi.bEc != null) {
                        this.bEi.bEc.a(true, error, errorString, this.bEi.bEb);
                    }
                }
            }
        }
    }
}
