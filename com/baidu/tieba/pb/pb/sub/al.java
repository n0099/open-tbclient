package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.ak;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ak cgZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(ak akVar, int i, int i2) {
        super(i, i2);
        this.cgZ = akVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        ak.a aVar3;
        ak.a aVar4;
        com.baidu.tieba.pb.a.c cVar;
        boolean z2;
        String str;
        com.baidu.tieba.pb.a.c cVar2;
        int i;
        int i2;
        int i3;
        com.baidu.tieba.pb.a.c cVar3;
        com.baidu.tieba.pb.a.c cVar4;
        com.baidu.tieba.pb.a.c cVar5;
        ak.a aVar5;
        ak.a aVar6;
        com.baidu.tieba.pb.a.c cVar6;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ak.a aVar7;
        ak.a aVar8;
        long j2;
        long j3;
        int i4;
        com.baidu.tieba.tbadkCore.e.a aVar9;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        com.baidu.tieba.pb.a.c cVar7;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.cgZ.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.cgZ.avu = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.cgZ.LS;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(i.C0057i.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.cgZ.LS;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.cgZ.LS;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.cgZ.b(subPbHttpResponseMessage.pbFloorData);
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
                        this.cgZ.b(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.cgZ.cgU;
            if (arrayList != null) {
                arrayList2 = this.cgZ.cgU;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.cgZ.cgU;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.cgZ.cgU;
                            cVar7 = this.cgZ.cgq;
                            cVar7.b((com.baidu.tieba.pb.a.c) arrayList5.get(size), true);
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.cgZ.cgU;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            aVar = this.cgZ.aMS;
            if (aVar == null) {
                this.cgZ.aMS = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
            }
            aVar2 = this.cgZ.aMS;
            if (aVar2 != null) {
                if (error == 0) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        int downSize = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        j2 = j4;
                        j3 = responsedMessage.getCostTime();
                        i4 = downSize;
                    } else if (!(responsedMessage instanceof SubPbSocketResponseMessage)) {
                        j2 = j4;
                        j3 = j;
                        i4 = -1;
                    } else {
                        int downSize2 = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                        j2 = responsedMessage.getCostTime();
                        j3 = j;
                        i4 = downSize2;
                    }
                    aVar9 = this.cgZ.aMS;
                    aVar9.a(z, true, error, errorString2, i4, j3, j2);
                    this.cgZ.aMS = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
                    this.cgZ.aMS = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar3 = this.cgZ.cgR;
                    if (aVar3 != null) {
                        aVar4 = this.cgZ.cgR;
                        aVar4.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        cVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        cVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (cVar.acP().errorno.intValue() != 0) {
                        aVar7 = this.cgZ.cgR;
                        if (aVar7 != null) {
                            aVar8 = this.cgZ.cgR;
                            aVar8.a(false, cVar.caq.errorno.intValue(), cVar.caq.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (cVar.acX() != null && cVar.acX().getAuthor() != null) {
                        str5 = cVar.acX().getAuthor().getUserId();
                    }
                    z2 = this.cgZ.cgW;
                    if (!z2) {
                        for (int i5 = 0; i5 < cVar.acS().size(); i5++) {
                            boolean equals = str5.equals(cVar.acS().get(i5).getAuthor().getUserId());
                            tbPageContext = this.cgZ.LS;
                            cVar.acS().get(i5).a(tbPageContext.getUniqueId(), equals);
                        }
                    }
                    if (cVar.acQ() != null) {
                        this.cgZ.postID = cVar.acQ().getId();
                    }
                    if (cVar.acX() != null) {
                        this.cgZ.threadID = cVar.acX().getId();
                        this.cgZ.cap = cVar.qr();
                        this.cgZ.cgQ = cVar.acX().sr();
                    }
                    str = this.cgZ.cgQ;
                    if (str != null) {
                        str2 = this.cgZ.postID;
                        if (str2 != null) {
                            str3 = this.cgZ.cgQ;
                            str4 = this.cgZ.postID;
                            if (str3.equals(str4)) {
                                this.cgZ.cap = true;
                            }
                        }
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.i> acS = cVar.acS();
                    if (acS == null || acS.size() == 0) {
                        cVar2 = this.cgZ.cgq;
                        cVar.setCurrentPage(cVar2.getCurrentPage());
                    }
                    i = this.cgZ.aRd;
                    if (i != 1) {
                        i2 = this.cgZ.aRd;
                        if (i2 != 2) {
                            i3 = this.cgZ.aRd;
                            if (i3 == 3) {
                                cVar4 = this.cgZ.cgq;
                                cVar4.a(cVar, false);
                            } else {
                                cVar3 = this.cgZ.cgq;
                                cVar3.b(cVar, false);
                            }
                        } else {
                            cVar5 = this.cgZ.cgq;
                            cVar5.b(cVar, true);
                        }
                    } else {
                        this.cgZ.cgq = cVar;
                    }
                    aVar5 = this.cgZ.cgR;
                    if (aVar5 != null) {
                        boolean z3 = this.cgZ.afp();
                        aVar6 = this.cgZ.cgR;
                        cVar6 = this.cgZ.cgq;
                        aVar6.a(z3, error, errorString2, cVar6);
                    }
                }
            }
        }
    }
}
