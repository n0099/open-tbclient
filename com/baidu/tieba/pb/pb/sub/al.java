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
    final /* synthetic */ ak cnE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(ak akVar, int i, int i2) {
        super(i, i2);
        this.cnE = akVar;
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
        boolean z3;
        ak.a aVar5;
        ak.a aVar6;
        com.baidu.tieba.pb.a.c cVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ak.a aVar7;
        ak.a aVar8;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.tbadkCore.e.a aVar9;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        boolean z4;
        com.baidu.tieba.pb.a.c cVar3;
        com.baidu.tieba.pb.a.c cVar4;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.cnE.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.cnE.avC = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.cnE.mContext;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(i.h.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.cnE.mContext;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.cnE.mContext;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.cnE.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.cnE.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.cnE.cnz;
            if (arrayList != null) {
                arrayList2 = this.cnE.cnz;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.cnE.cnz;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.cnE.cnz;
                            com.baidu.tieba.pb.a.c cVar5 = (com.baidu.tieba.pb.a.c) arrayList5.get(size);
                            z4 = this.cnE.cnB;
                            if (z4) {
                                cVar4 = this.cnE.cmV;
                                cVar4.c(cVar5, true);
                            } else {
                                cVar3 = this.cnE.cmV;
                                cVar3.b(cVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.cnE.cnz;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            aVar = this.cnE.aMl;
            if (aVar == null) {
                this.cnE.aMl = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
            }
            aVar2 = this.cnE.aMl;
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
                    aVar9 = this.cnE.aMl;
                    aVar9.a(z, true, error, errorString2, i, j3, j2);
                    this.cnE.aMl = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
                    this.cnE.aMl = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar3 = this.cnE.cnv;
                    if (aVar3 != null) {
                        aVar4 = this.cnE.cnv;
                        aVar4.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        cVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        cVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (cVar.aeY().errorno.intValue() != 0) {
                        aVar7 = this.cnE.cnv;
                        if (aVar7 != null) {
                            aVar8 = this.cnE.cnv;
                            aVar8.a(false, cVar.cgB.errorno.intValue(), cVar.cgB.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (cVar.afi() != null && cVar.afi().getAuthor() != null) {
                        str5 = cVar.afi().getAuthor().getUserId();
                    }
                    z2 = this.cnE.cnB;
                    if (!z2) {
                        for (int i2 = 0; i2 < cVar.afd().size(); i2++) {
                            boolean equals = str5.equals(cVar.afd().get(i2).getAuthor().getUserId());
                            tbPageContext = this.cnE.mContext;
                            cVar.afd().get(i2).a(tbPageContext.getUniqueId(), equals);
                        }
                    }
                    if (cVar.aeZ() != null) {
                        this.cnE.postID = cVar.aeZ().getId();
                    }
                    if (cVar.afi() != null) {
                        this.cnE.threadID = cVar.afi().getId();
                        this.cnE.cgA = cVar.qk();
                        this.cnE.cnu = cVar.afi().sn();
                    }
                    str = this.cnE.cnu;
                    if (str != null) {
                        str2 = this.cnE.postID;
                        if (str2 != null) {
                            str3 = this.cnE.cnu;
                            str4 = this.cnE.postID;
                            if (str3.equals(str4)) {
                                this.cnE.cgA = true;
                            }
                        }
                    }
                    z3 = this.cnE.cnB;
                    if (!z3) {
                        this.cnE.c(cVar);
                    } else {
                        this.cnE.d(cVar);
                    }
                    aVar5 = this.cnE.cnv;
                    if (aVar5 != null) {
                        boolean z5 = this.cnE.ahB();
                        aVar6 = this.cnE.cnv;
                        cVar2 = this.cnE.cmV;
                        aVar6.a(z5, error, errorString2, cVar2);
                    }
                }
            }
        }
    }
}
