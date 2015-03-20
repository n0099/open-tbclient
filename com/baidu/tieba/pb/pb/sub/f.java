package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.y;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ e bNA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, int i2) {
        super(i, i2);
        this.bNA = eVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        com.baidu.tieba.pb.a.c cVar;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.tbadkCore.e.a aVar3;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        long j4 = 0;
        String str = null;
        bdUniqueId = this.bNA.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.bNA.amT = false;
            if (responsedMessage.hasError()) {
                this.bNA.bNs.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bNA.bNs.getResources().getString(y.neterror) : responsedMessage.getErrorString());
                if (responsedMessage.getError() == 4) {
                    this.bNA.bNs.finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.bNA.b(subPbHttpResponseMessage.pbFloorData);
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
                        this.bNA.b(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.bNA.bNx;
            if (arrayList != null) {
                arrayList2 = this.bNA.bNx;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.bNA.bNx;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.bNA.bNx;
                            this.bNA.bNt.b((com.baidu.tieba.pb.a.c) arrayList5.get(size), true);
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.bNA.bNx;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            aVar = this.bNA.aDi;
            if (aVar == null) {
                this.bNA.aDi = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
            }
            aVar2 = this.bNA.aDi;
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
                    aVar3 = this.bNA.aDi;
                    aVar3.a(z, true, error, errorString, i, j3, j2);
                    this.bNA.aDi = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
                    this.bNA.aDi = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    if (this.bNA.bNu != null) {
                        this.bNA.bNu.b(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        cVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        cVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (cVar.YW().errorno.intValue() != 0) {
                        if (this.bNA.bNu != null) {
                            this.bNA.bNu.b(false, cVar.bHu.errorno.intValue(), cVar.bHu.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (cVar.Zd() != null && cVar.Zd().getAuthor() != null) {
                        str = cVar.Zd().getAuthor().getUserId();
                    }
                    for (int i2 = 0; i2 < cVar.YZ().size(); i2++) {
                        cVar.YZ().get(i2).b(this.bNA.bNs.getPageContext(), str.equals(cVar.YZ().get(i2).getAuthor().getUserId()));
                    }
                    if (cVar.YX() != null) {
                        this.bNA.postID = cVar.YX().getId();
                    }
                    if (cVar.Zd() != null) {
                        this.bNA.bNr = cVar.Zd().getId();
                    }
                    if (this.bNA.mLoadType == 1) {
                        this.bNA.bNt = cVar;
                    } else if (this.bNA.mLoadType == 2) {
                        this.bNA.bNt.b(cVar, true);
                    } else if (this.bNA.mLoadType == 3) {
                        this.bNA.bNt.a(cVar, false);
                    } else {
                        this.bNA.bNt.b(cVar, false);
                    }
                    if (this.bNA.bNu != null) {
                        this.bNA.bNu.b(true, error, errorString, this.bNA.bNt);
                    }
                }
            }
        }
    }
}
