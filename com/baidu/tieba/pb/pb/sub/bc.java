package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ SubPbModel ezA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(SubPbModel subPbModel, int i, int i2) {
        super(i, i2);
        this.ezA = subPbModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.d.b bVar;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        SubPbModel.a aVar;
        SubPbModel.a aVar2;
        com.baidu.tieba.pb.data.n nVar;
        boolean z2;
        String str;
        boolean z3;
        SubPbModel.a aVar3;
        SubPbModel.a aVar4;
        com.baidu.tieba.pb.data.n nVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ArrayList arrayList2;
        ArrayList<IconData> arrayList3;
        SubPbModel.a aVar5;
        SubPbModel.a aVar6;
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
        TbPageContext tbPageContext2;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.ezA.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.ezA.isLoading = false;
            if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                tbPageContext2 = this.ezA.aas;
                tbPageContext2.getPageActivity().finish();
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.ezA.g(subPbHttpResponseMessage.pbFloorData);
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
                        this.ezA.g(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.ezA.ezs;
            if (arrayList != null) {
                arrayList4 = this.ezA.ezs;
                if (arrayList4.size() > 0) {
                    try {
                        arrayList6 = this.ezA.ezs;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            arrayList7 = this.ezA.ezs;
                            com.baidu.tieba.pb.data.n nVar5 = (com.baidu.tieba.pb.data.n) arrayList7.get(size);
                            z4 = this.ezA.ezu;
                            if (z4) {
                                nVar4 = this.ezA.ewW;
                                nVar4.c(nVar5, true);
                            } else {
                                nVar3 = this.ezA.ewW;
                                nVar3.b(nVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList5 = this.ezA.ezs;
                    arrayList5.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            bVar = this.ezA.bNa;
            if (bVar == null) {
                this.ezA.bNa = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.ezA.bNa;
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
                    bVar3 = this.ezA.bNa;
                    bVar3.a(z, true, error, errorString, i, j3, j2);
                    this.ezA.bNa = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.ezA.bNa = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.ezA.ezo;
                    if (aVar != null) {
                        aVar2 = this.ezA.ezo;
                        aVar2.a(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        nVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (nVar.aJi().errorno.intValue() != 0) {
                        aVar5 = this.ezA.ezo;
                        if (aVar5 != null) {
                            aVar6 = this.ezA.ezo;
                            aVar6.a(false, nVar.ejt.errorno.intValue(), nVar.ejt.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (nVar.LH() != null && nVar.LH().getAuthor() != null) {
                        str5 = nVar.LH().getAuthor().getUserId();
                        if (com.baidu.tbadk.core.util.x.r(nVar.aJj().getAuthor().getIconInfo())) {
                            arrayList2 = this.ezA.ezq;
                            if (arrayList2 != null) {
                                MetaData author = nVar.aJj().getAuthor();
                                arrayList3 = this.ezA.ezq;
                                author.setIconInfo(arrayList3);
                            }
                        }
                    }
                    z2 = this.ezA.ezu;
                    if (!z2) {
                        for (int i2 = 0; i2 < nVar.aJn().size(); i2++) {
                            boolean equals = str5.equals(nVar.aJn().get(i2).getAuthor().getUserId());
                            tbPageContext = this.ezA.aas;
                            nVar.aJn().get(i2).a(tbPageContext, equals);
                        }
                    }
                    if (nVar.aJj() != null) {
                        this.ezA.postID = nVar.aJj().getId();
                    }
                    if (nVar.LH() != null) {
                        this.ezA.threadID = nVar.LH().getId();
                        this.ezA.ejs = nVar.nD();
                        this.ezA.ezn = nVar.LH().rD();
                    }
                    str = this.ezA.ezn;
                    if (str != null) {
                        str2 = this.ezA.postID;
                        if (str2 != null) {
                            str3 = this.ezA.ezn;
                            str4 = this.ezA.postID;
                            if (str3.equals(str4)) {
                                this.ezA.ejs = true;
                            }
                        }
                    }
                    z3 = this.ezA.ezu;
                    if (!z3) {
                        this.ezA.e(nVar);
                    } else {
                        this.ezA.f(nVar);
                    }
                    aVar3 = this.ezA.ezo;
                    if (aVar3 != null) {
                        boolean z5 = this.ezA.aOo();
                        aVar4 = this.ezA.ezo;
                        nVar2 = this.ezA.ewW;
                        aVar4.a(z5, error, errorString, nVar2);
                    }
                }
            }
        }
    }
}
