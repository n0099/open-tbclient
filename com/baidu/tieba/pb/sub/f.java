package com.baidu.tieba.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ e bFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, int i, int i2) {
        super(i, i2);
        this.bFS = eVar;
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
        bdUniqueId = this.bFS.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.bFS.aez = false;
            if (responsedMessage.hasError()) {
                this.bFS.bFK.showToast(responsedMessage.getErrorString());
                if (responsedMessage.getError() == 4) {
                    this.bFS.bFK.finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.bFS.b(subPbHttpResponseMessage.pbFloorData);
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
                        this.bFS.b(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.bFS.bFP;
            if (arrayList != null) {
                arrayList2 = this.bFS.bFP;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.bFS.bFP;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.bFS.bFP;
                            this.bFS.bFL.b((com.baidu.tieba.tbadkCore.b.o) arrayList5.get(size), true);
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.bFS.bFP;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            aVar = this.bFS.aDe;
            if (aVar == null) {
                this.bFS.aDe = new com.baidu.tieba.tbadkCore.d.a("pbfloorStat");
            }
            aVar2 = this.bFS.aDe;
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
                    aVar3 = this.bFS.aDe;
                    aVar3.a(z, true, error, errorString, i, j3, j2);
                    this.bFS.aDe = new com.baidu.tieba.tbadkCore.d.a("pbfloorStat");
                    this.bFS.aDe = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    if (this.bFS.bFM != null) {
                        this.bFS.bFM.a(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        oVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        oVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (oVar.ahB().errorno.intValue() != 0) {
                        if (this.bFS.bFM != null) {
                            this.bFS.bFM.a(false, oVar.bZb.errorno.intValue(), oVar.bZb.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (oVar.ahH() != null && oVar.ahH().getAuthor() != null) {
                        str = oVar.ahH().getAuthor().getUserId();
                    }
                    for (int i2 = 0; i2 < oVar.ahE().size(); i2++) {
                        oVar.ahE().get(i2).a(this.bFS.bFK.getPageContext(), str.equals(oVar.ahE().get(i2).getAuthor().getUserId()));
                    }
                    if (oVar.ahC() != null) {
                        this.bFS.Ba = oVar.ahC().getId();
                    }
                    if (oVar.ahH() != null) {
                        this.bFS.bFJ = oVar.ahH().getId();
                    }
                    if (this.bFS.mLoadType == 1) {
                        this.bFS.bFL = oVar;
                    } else if (this.bFS.mLoadType == 2) {
                        this.bFS.bFL.b(oVar, true);
                    } else if (this.bFS.mLoadType == 3) {
                        this.bFS.bFL.a(oVar, false);
                    } else {
                        this.bFS.bFL.b(oVar, false);
                    }
                    if (this.bFS.bFM != null) {
                        this.bFS.bFM.a(true, error, errorString, this.bFS.bFL);
                    }
                }
            }
        }
    }
}
