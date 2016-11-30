package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.pb.pb.sub.bc;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ bc eFM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(bc bcVar, int i, int i2) {
        super(i, i2);
        this.eFM = bcVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.d.b bVar;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        bc.a aVar;
        bc.a aVar2;
        com.baidu.tieba.pb.data.n nVar;
        boolean z2;
        String str;
        boolean z3;
        bc.a aVar3;
        bc.a aVar4;
        com.baidu.tieba.pb.data.n nVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ArrayList arrayList2;
        ArrayList<IconData> arrayList3;
        bc.a aVar5;
        bc.a aVar6;
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
        bdUniqueId = this.eFM.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.eFM.aAG = false;
            if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                tbPageContext2 = this.eFM.Gf;
                tbPageContext2.getPageActivity().finish();
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.eFM.f(subPbHttpResponseMessage.pbFloorData);
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
                        this.eFM.f(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.eFM.eFE;
            if (arrayList != null) {
                arrayList4 = this.eFM.eFE;
                if (arrayList4.size() > 0) {
                    try {
                        arrayList6 = this.eFM.eFE;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            arrayList7 = this.eFM.eFE;
                            com.baidu.tieba.pb.data.n nVar5 = (com.baidu.tieba.pb.data.n) arrayList7.get(size);
                            z4 = this.eFM.eFG;
                            if (z4) {
                                nVar4 = this.eFM.eDA;
                                nVar4.c(nVar5, true);
                            } else {
                                nVar3 = this.eFM.eDA;
                                nVar3.b(nVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList5 = this.eFM.eFE;
                    arrayList5.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            bVar = this.eFM.bKu;
            if (bVar == null) {
                this.eFM.bKu = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.eFM.bKu;
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
                    bVar3 = this.eFM.bKu;
                    bVar3.a(z, true, error, errorString, i, j3, j2);
                    this.eFM.bKu = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.eFM.bKu = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.eFM.eFA;
                    if (aVar != null) {
                        aVar2 = this.eFM.eFA;
                        aVar2.a(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        nVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (nVar.aOF().errorno.intValue() != 0) {
                        aVar5 = this.eFM.eFA;
                        if (aVar5 != null) {
                            aVar6 = this.eFM.eFA;
                            aVar6.a(false, nVar.esF.errorno.intValue(), nVar.esF.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (nVar.Jz() != null && nVar.Jz().getAuthor() != null) {
                        str5 = nVar.Jz().getAuthor().getUserId();
                        if (com.baidu.tbadk.core.util.x.t(nVar.aOG().getAuthor().getIconInfo())) {
                            arrayList2 = this.eFM.eFC;
                            if (arrayList2 != null) {
                                MetaData author = nVar.aOG().getAuthor();
                                arrayList3 = this.eFM.eFC;
                                author.setIconInfo(arrayList3);
                            }
                        }
                    }
                    z2 = this.eFM.eFG;
                    if (!z2) {
                        for (int i2 = 0; i2 < nVar.aOK().size(); i2++) {
                            boolean equals = str5.equals(nVar.aOK().get(i2).getAuthor().getUserId());
                            tbPageContext = this.eFM.Gf;
                            nVar.aOK().get(i2).b(tbPageContext, equals);
                        }
                    }
                    if (nVar.aOG() != null) {
                        this.eFM.postID = nVar.aOG().getId();
                    }
                    if (nVar.Jz() != null) {
                        this.eFM.threadID = nVar.Jz().getId();
                        this.eFM.esE = nVar.nz();
                        this.eFM.eFz = nVar.Jz().rX();
                    }
                    str = this.eFM.eFz;
                    if (str != null) {
                        str2 = this.eFM.postID;
                        if (str2 != null) {
                            str3 = this.eFM.eFz;
                            str4 = this.eFM.postID;
                            if (str3.equals(str4)) {
                                this.eFM.esE = true;
                            }
                        }
                    }
                    z3 = this.eFM.eFG;
                    if (!z3) {
                        this.eFM.d(nVar);
                    } else {
                        this.eFM.e(nVar);
                    }
                    aVar3 = this.eFM.eFA;
                    if (aVar3 != null) {
                        boolean z5 = this.eFM.aTB();
                        aVar4 = this.eFM.eFA;
                        nVar2 = this.eFM.eDA;
                        aVar4.a(z5, error, errorString, nVar2);
                    }
                }
            }
        }
    }
}
