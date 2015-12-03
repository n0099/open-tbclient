package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.sub.an;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ an cIh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(an anVar, int i, int i2) {
        super(i, i2);
        this.cIh = anVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.d.a aVar;
        com.baidu.tieba.tbadkCore.d.a aVar2;
        an.a aVar3;
        an.a aVar4;
        com.baidu.tieba.pb.a.d dVar;
        boolean z2;
        String str;
        boolean z3;
        an.a aVar5;
        an.a aVar6;
        com.baidu.tieba.pb.a.d dVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        an.a aVar7;
        an.a aVar8;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.tbadkCore.d.a aVar9;
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
        bdUniqueId = this.cIh.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.cIh.awu = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.cIh.mContext;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(n.i.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.cIh.mContext;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.cIh.mContext;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.cIh.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.cIh.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.cIh.cIc;
            if (arrayList != null) {
                arrayList2 = this.cIh.cIc;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.cIh.cIc;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.cIh.cIc;
                            com.baidu.tieba.pb.a.d dVar5 = (com.baidu.tieba.pb.a.d) arrayList5.get(size);
                            z4 = this.cIh.cIe;
                            if (z4) {
                                dVar4 = this.cIh.cHy;
                                dVar4.c(dVar5, true);
                            } else {
                                dVar3 = this.cIh.cHy;
                                dVar3.b(dVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.cIh.cIc;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            aVar = this.cIh.aRc;
            if (aVar == null) {
                this.cIh.aRc = new com.baidu.tieba.tbadkCore.d.a("pbfloorStat");
            }
            aVar2 = this.cIh.aRc;
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
                    aVar9 = this.cIh.aRc;
                    aVar9.a(z, true, error, errorString2, i, j3, j2);
                    this.cIh.aRc = new com.baidu.tieba.tbadkCore.d.a("pbfloorStat");
                    this.cIh.aRc = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar3 = this.cIh.cHY;
                    if (aVar3 != null) {
                        aVar4 = this.cIh.cHY;
                        aVar4.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        dVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        dVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (dVar.ajJ().errorno.intValue() != 0) {
                        aVar7 = this.cIh.cHY;
                        if (aVar7 != null) {
                            aVar8 = this.cIh.cHY;
                            aVar8.a(false, dVar.czD.errorno.intValue(), dVar.czD.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (dVar.ajT() != null && dVar.ajT().getAuthor() != null) {
                        str5 = dVar.ajT().getAuthor().getUserId();
                    }
                    z2 = this.cIh.cIe;
                    if (!z2) {
                        for (int i2 = 0; i2 < dVar.ajO().size(); i2++) {
                            boolean equals = str5.equals(dVar.ajO().get(i2).getAuthor().getUserId());
                            tbPageContext = this.cIh.mContext;
                            dVar.ajO().get(i2).a(tbPageContext.getUniqueId(), equals);
                        }
                    }
                    if (dVar.ajK() != null) {
                        this.cIh.postID = dVar.ajK().getId();
                    }
                    if (dVar.ajT() != null) {
                        this.cIh.threadID = dVar.ajT().getId();
                        this.cIh.czC = dVar.qp();
                        this.cIh.cHX = dVar.ajT().sP();
                    }
                    str = this.cIh.cHX;
                    if (str != null) {
                        str2 = this.cIh.postID;
                        if (str2 != null) {
                            str3 = this.cIh.cHX;
                            str4 = this.cIh.postID;
                            if (str3.equals(str4)) {
                                this.cIh.czC = true;
                            }
                        }
                    }
                    z3 = this.cIh.cIe;
                    if (!z3) {
                        this.cIh.c(dVar);
                    } else {
                        this.cIh.d(dVar);
                    }
                    aVar5 = this.cIh.cHY;
                    if (aVar5 != null) {
                        boolean z5 = this.cIh.amG();
                        aVar6 = this.cIh.cHY;
                        dVar2 = this.cIh.cHy;
                        aVar6.a(z5, error, errorString2, dVar2);
                    }
                }
            }
        }
    }
}
