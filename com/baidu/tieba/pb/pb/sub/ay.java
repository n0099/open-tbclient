package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.pb.pb.sub.ax;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ax ezb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(ax axVar, int i, int i2) {
        super(i, i2);
        this.ezb = axVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.d.b bVar;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        ax.a aVar;
        ax.a aVar2;
        com.baidu.tieba.pb.data.n nVar;
        boolean z2;
        String str;
        boolean z3;
        ax.a aVar3;
        ax.a aVar4;
        com.baidu.tieba.pb.data.n nVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ArrayList arrayList2;
        ArrayList<IconData> arrayList3;
        ax.a aVar5;
        ax.a aVar6;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.tbadkCore.d.b bVar3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        boolean z4;
        com.baidu.tieba.pb.data.n nVar3;
        com.baidu.tieba.pb.data.n nVar4;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.ezb.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.ezb.azO = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.ezb.Gd;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(r.j.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.ezb.Gd;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.ezb.Gd;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.ezb.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.ezb.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.ezb.eyT;
            if (arrayList != null) {
                arrayList4 = this.ezb.eyT;
                if (arrayList4.size() > 0) {
                    try {
                        arrayList6 = this.ezb.eyT;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            arrayList7 = this.ezb.eyT;
                            com.baidu.tieba.pb.data.n nVar5 = (com.baidu.tieba.pb.data.n) arrayList7.get(size);
                            z4 = this.ezb.eyV;
                            if (z4) {
                                nVar4 = this.ezb.eyl;
                                nVar4.c(nVar5, true);
                            } else {
                                nVar3 = this.ezb.eyl;
                                nVar3.b(nVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList5 = this.ezb.eyT;
                    arrayList5.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            bVar = this.ezb.bHA;
            if (bVar == null) {
                this.ezb.bHA = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.ezb.bHA;
            if (bVar2 != null) {
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
                    bVar3 = this.ezb.bHA;
                    bVar3.a(z, true, error, errorString2, i, j3, j2);
                    this.ezb.bHA = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.ezb.bHA = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.ezb.eyO;
                    if (aVar != null) {
                        aVar2 = this.ezb.eyO;
                        aVar2.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        nVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (nVar.aMM().errorno.intValue() != 0) {
                        aVar5 = this.ezb.eyO;
                        if (aVar5 != null) {
                            aVar6 = this.ezb.eyO;
                            aVar6.a(false, nVar.emI.errorno.intValue(), nVar.emI.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (nVar.Jv() != null && nVar.Jv().getAuthor() != null) {
                        str5 = nVar.Jv().getAuthor().getUserId();
                        if (com.baidu.tbadk.core.util.y.t(nVar.aMN().getAuthor().getIconInfo())) {
                            arrayList2 = this.ezb.eyQ;
                            if (arrayList2 != null) {
                                MetaData author = nVar.aMN().getAuthor();
                                arrayList3 = this.ezb.eyQ;
                                author.setIconInfo(arrayList3);
                            }
                        }
                    }
                    z2 = this.ezb.eyV;
                    if (!z2) {
                        for (int i2 = 0; i2 < nVar.aMR().size(); i2++) {
                            boolean equals = str5.equals(nVar.aMR().get(i2).getAuthor().getUserId());
                            tbPageContext = this.ezb.Gd;
                            nVar.aMR().get(i2).c(tbPageContext, equals);
                        }
                    }
                    if (nVar.aMN() != null) {
                        this.ezb.postID = nVar.aMN().getId();
                    }
                    if (nVar.Jv() != null) {
                        this.ezb.threadID = nVar.Jv().getId();
                        this.ezb.emH = nVar.nv();
                        this.ezb.eyN = nVar.Jv().rV();
                    }
                    str = this.ezb.eyN;
                    if (str != null) {
                        str2 = this.ezb.postID;
                        if (str2 != null) {
                            str3 = this.ezb.eyN;
                            str4 = this.ezb.postID;
                            if (str3.equals(str4)) {
                                this.ezb.emH = true;
                            }
                        }
                    }
                    z3 = this.ezb.eyV;
                    if (!z3) {
                        this.ezb.c(nVar);
                    } else {
                        this.ezb.d(nVar);
                    }
                    aVar3 = this.ezb.eyO;
                    if (aVar3 != null) {
                        boolean z5 = this.ezb.aRt();
                        aVar4 = this.ezb.eyO;
                        nVar2 = this.ezb.eyl;
                        aVar4.a(z5, error, errorString2, nVar2);
                    }
                }
            }
        }
    }
}
