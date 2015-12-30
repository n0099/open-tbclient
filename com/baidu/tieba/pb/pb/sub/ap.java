package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.sub.ao;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ao cMj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(ao aoVar, int i, int i2) {
        super(i, i2);
        this.cMj = aoVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.d.a aVar;
        com.baidu.tieba.tbadkCore.d.a aVar2;
        ao.a aVar3;
        ao.a aVar4;
        com.baidu.tieba.pb.a.d dVar;
        boolean z2;
        String str;
        boolean z3;
        ao.a aVar5;
        ao.a aVar6;
        com.baidu.tieba.pb.a.d dVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ao.a aVar7;
        ao.a aVar8;
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
        bdUniqueId = this.cMj.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.cMj.axY = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.cMj.mContext;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(n.j.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.cMj.mContext;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.cMj.mContext;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.cMj.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.cMj.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.cMj.cMe;
            if (arrayList != null) {
                arrayList2 = this.cMj.cMe;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.cMj.cMe;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.cMj.cMe;
                            com.baidu.tieba.pb.a.d dVar5 = (com.baidu.tieba.pb.a.d) arrayList5.get(size);
                            z4 = this.cMj.cMg;
                            if (z4) {
                                dVar4 = this.cMj.cLA;
                                dVar4.c(dVar5, true);
                            } else {
                                dVar3 = this.cMj.cLA;
                                dVar3.b(dVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.cMj.cMe;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            aVar = this.cMj.aUT;
            if (aVar == null) {
                this.cMj.aUT = new com.baidu.tieba.tbadkCore.d.a("pbfloorStat");
            }
            aVar2 = this.cMj.aUT;
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
                    aVar9 = this.cMj.aUT;
                    aVar9.a(z, true, error, errorString2, i, j3, j2);
                    this.cMj.aUT = new com.baidu.tieba.tbadkCore.d.a("pbfloorStat");
                    this.cMj.aUT = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar3 = this.cMj.cMa;
                    if (aVar3 != null) {
                        aVar4 = this.cMj.cMa;
                        aVar4.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        dVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        dVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (dVar.akR().errorno.intValue() != 0) {
                        aVar7 = this.cMj.cMa;
                        if (aVar7 != null) {
                            aVar8 = this.cMj.cMa;
                            aVar8.a(false, dVar.cDi.errorno.intValue(), dVar.cDi.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (dVar.Iv() != null && dVar.Iv().getAuthor() != null) {
                        str5 = dVar.Iv().getAuthor().getUserId();
                    }
                    z2 = this.cMj.cMg;
                    if (!z2) {
                        for (int i2 = 0; i2 < dVar.akW().size(); i2++) {
                            boolean equals = str5.equals(dVar.akW().get(i2).getAuthor().getUserId());
                            tbPageContext = this.cMj.mContext;
                            dVar.akW().get(i2).a(tbPageContext.getUniqueId(), equals);
                        }
                    }
                    if (dVar.akS() != null) {
                        this.cMj.postID = dVar.akS().getId();
                    }
                    if (dVar.Iv() != null) {
                        this.cMj.threadID = dVar.Iv().getId();
                        this.cMj.cDh = dVar.pN();
                        this.cMj.cLZ = dVar.Iv().sz();
                    }
                    str = this.cMj.cLZ;
                    if (str != null) {
                        str2 = this.cMj.postID;
                        if (str2 != null) {
                            str3 = this.cMj.cLZ;
                            str4 = this.cMj.postID;
                            if (str3.equals(str4)) {
                                this.cMj.cDh = true;
                            }
                        }
                    }
                    z3 = this.cMj.cMg;
                    if (!z3) {
                        this.cMj.c(dVar);
                    } else {
                        this.cMj.d(dVar);
                    }
                    aVar5 = this.cMj.cMa;
                    if (aVar5 != null) {
                        boolean z5 = this.cMj.anS();
                        aVar6 = this.cMj.cMa;
                        dVar2 = this.cMj.cLA;
                        aVar6.a(z5, error, errorString2, dVar2);
                    }
                }
            }
        }
    }
}
