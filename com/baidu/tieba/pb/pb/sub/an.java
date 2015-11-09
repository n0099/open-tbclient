package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.am;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ am coV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(am amVar, int i, int i2) {
        super(i, i2);
        this.coV = amVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        am.a aVar3;
        am.a aVar4;
        com.baidu.tieba.pb.a.d dVar;
        boolean z2;
        String str;
        boolean z3;
        am.a aVar5;
        am.a aVar6;
        com.baidu.tieba.pb.a.d dVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        am.a aVar7;
        am.a aVar8;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.tbadkCore.e.a aVar9;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        boolean z4;
        com.baidu.tieba.pb.a.d dVar3;
        com.baidu.tieba.pb.a.d dVar4;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.coV.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.coV.auq = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.coV.mContext;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(i.h.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.coV.mContext;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.coV.mContext;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.coV.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.coV.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.coV.coQ;
            if (arrayList != null) {
                arrayList2 = this.coV.coQ;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.coV.coQ;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.coV.coQ;
                            com.baidu.tieba.pb.a.d dVar5 = (com.baidu.tieba.pb.a.d) arrayList5.get(size);
                            z4 = this.coV.coS;
                            if (z4) {
                                dVar4 = this.coV.f127com;
                                dVar4.c(dVar5, true);
                            } else {
                                dVar3 = this.coV.f127com;
                                dVar3.b(dVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.coV.coQ;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            aVar = this.coV.aMt;
            if (aVar == null) {
                this.coV.aMt = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
            }
            aVar2 = this.coV.aMt;
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
                    aVar9 = this.coV.aMt;
                    aVar9.a(z, true, error, errorString2, i, j3, j2);
                    this.coV.aMt = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
                    this.coV.aMt = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar3 = this.coV.coM;
                    if (aVar3 != null) {
                        aVar4 = this.coV.coM;
                        aVar4.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        dVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        dVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (dVar.afr().errorno.intValue() != 0) {
                        aVar7 = this.coV.coM;
                        if (aVar7 != null) {
                            aVar8 = this.coV.coM;
                            aVar8.a(false, dVar.chg.errorno.intValue(), dVar.chg.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (dVar.afB() != null && dVar.afB().getAuthor() != null) {
                        str5 = dVar.afB().getAuthor().getUserId();
                    }
                    z2 = this.coV.coS;
                    if (!z2) {
                        for (int i2 = 0; i2 < dVar.afw().size(); i2++) {
                            boolean equals = str5.equals(dVar.afw().get(i2).getAuthor().getUserId());
                            tbPageContext = this.coV.mContext;
                            dVar.afw().get(i2).a(tbPageContext.getUniqueId(), equals);
                        }
                    }
                    if (dVar.afs() != null) {
                        this.coV.postID = dVar.afs().getId();
                    }
                    if (dVar.afB() != null) {
                        this.coV.threadID = dVar.afB().getId();
                        this.coV.chf = dVar.qi();
                        this.coV.coL = dVar.afB().sn();
                    }
                    str = this.coV.coL;
                    if (str != null) {
                        str2 = this.coV.postID;
                        if (str2 != null) {
                            str3 = this.coV.coL;
                            str4 = this.coV.postID;
                            if (str3.equals(str4)) {
                                this.coV.chf = true;
                            }
                        }
                    }
                    z3 = this.coV.coS;
                    if (!z3) {
                        this.coV.c(dVar);
                    } else {
                        this.coV.d(dVar);
                    }
                    aVar5 = this.coV.coM;
                    if (aVar5 != null) {
                        boolean z5 = this.coV.aid();
                        aVar6 = this.coV.coM;
                        dVar2 = this.coV.f127com;
                        aVar6.a(z5, error, errorString2, dVar2);
                    }
                }
            }
        }
    }
}
