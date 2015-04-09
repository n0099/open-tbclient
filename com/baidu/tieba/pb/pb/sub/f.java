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
    final /* synthetic */ e bNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, int i2) {
        super(i, i2);
        this.bNQ = eVar;
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
        bdUniqueId = this.bNQ.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.bNQ.anb = false;
            if (responsedMessage.hasError()) {
                this.bNQ.bNI.showToast(StringUtils.isNull(responsedMessage.getErrorString()) ? this.bNQ.bNI.getResources().getString(y.neterror) : responsedMessage.getErrorString());
                if (responsedMessage.getError() == 4) {
                    this.bNQ.bNI.finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.bNQ.b(subPbHttpResponseMessage.pbFloorData);
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
                        this.bNQ.b(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.bNQ.bNN;
            if (arrayList != null) {
                arrayList2 = this.bNQ.bNN;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.bNQ.bNN;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.bNQ.bNN;
                            this.bNQ.bNJ.b((com.baidu.tieba.pb.a.c) arrayList5.get(size), true);
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.bNQ.bNN;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            aVar = this.bNQ.aDq;
            if (aVar == null) {
                this.bNQ.aDq = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
            }
            aVar2 = this.bNQ.aDq;
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
                    aVar3 = this.bNQ.aDq;
                    aVar3.a(z, true, error, errorString, i, j3, j2);
                    this.bNQ.aDq = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
                    this.bNQ.aDq = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    if (this.bNQ.bNK != null) {
                        this.bNQ.bNK.b(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        cVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        cVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (cVar.Zi().errorno.intValue() != 0) {
                        if (this.bNQ.bNK != null) {
                            this.bNQ.bNK.b(false, cVar.bHH.errorno.intValue(), cVar.bHH.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (cVar.Zq() != null && cVar.Zq().getAuthor() != null) {
                        str = cVar.Zq().getAuthor().getUserId();
                    }
                    for (int i2 = 0; i2 < cVar.Zl().size(); i2++) {
                        cVar.Zl().get(i2).b(this.bNQ.bNI.getPageContext(), str.equals(cVar.Zl().get(i2).getAuthor().getUserId()));
                    }
                    if (cVar.Zj() != null) {
                        this.bNQ.postID = cVar.Zj().getId();
                    }
                    if (cVar.Zq() != null) {
                        this.bNQ.bNH = cVar.Zq().getId();
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.c.j> Zl = cVar.Zl();
                    if (Zl == null || Zl.size() == 0) {
                        cVar.aM(this.bNQ.bNJ.getCurrentPage());
                    }
                    if (this.bNQ.mLoadType == 1) {
                        this.bNQ.bNJ = cVar;
                    } else if (this.bNQ.mLoadType == 2) {
                        this.bNQ.bNJ.b(cVar, true);
                    } else if (this.bNQ.mLoadType == 3) {
                        this.bNQ.bNJ.a(cVar, false);
                    } else {
                        this.bNQ.bNJ.b(cVar, false);
                    }
                    if (this.bNQ.bNK != null) {
                        this.bNQ.bNK.b(true, error, errorString, this.bNQ.bNJ);
                    }
                }
            }
        }
    }
}
