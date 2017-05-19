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
    final /* synthetic */ SubPbModel eso;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(SubPbModel subPbModel, int i, int i2) {
        super(i, i2);
        this.eso = subPbModel;
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
        com.baidu.tieba.pb.data.l lVar;
        boolean z2;
        String str;
        boolean z3;
        SubPbModel.a aVar3;
        SubPbModel.a aVar4;
        com.baidu.tieba.pb.data.l lVar2;
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
        com.baidu.tieba.pb.data.l lVar3;
        com.baidu.tieba.pb.data.l lVar4;
        TbPageContext tbPageContext2;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.eso.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.eso.isLoading = false;
            if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                tbPageContext2 = this.eso.aat;
                tbPageContext2.getPageActivity().finish();
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.eso.g(subPbHttpResponseMessage.pbFloorData);
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
                        this.eso.g(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.eso.esg;
            if (arrayList != null) {
                arrayList4 = this.eso.esg;
                if (arrayList4.size() > 0) {
                    try {
                        arrayList6 = this.eso.esg;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            arrayList7 = this.eso.esg;
                            com.baidu.tieba.pb.data.l lVar5 = (com.baidu.tieba.pb.data.l) arrayList7.get(size);
                            z4 = this.eso.esi;
                            if (z4) {
                                lVar4 = this.eso.epO;
                                lVar4.c(lVar5, true);
                            } else {
                                lVar3 = this.eso.epO;
                                lVar3.b(lVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList5 = this.eso.esg;
                    arrayList5.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            bVar = this.eso.bHm;
            if (bVar == null) {
                this.eso.bHm = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.eso.bHm;
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
                    bVar3 = this.eso.bHm;
                    bVar3.a(z, true, error, errorString, i, j3, j2);
                    this.eso.bHm = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.eso.bHm = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.eso.esc;
                    if (aVar != null) {
                        aVar2 = this.eso.esc;
                        aVar2.a(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        lVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        lVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (lVar.aIq().errorno.intValue() != 0) {
                        aVar5 = this.eso.esc;
                        if (aVar5 != null) {
                            aVar6 = this.eso.esc;
                            aVar6.a(false, lVar.edT.errorno.intValue(), lVar.edT.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (lVar.JB() != null && lVar.JB().getAuthor() != null) {
                        str5 = lVar.JB().getAuthor().getUserId();
                        if (com.baidu.tbadk.core.util.x.r(lVar.aIr().getAuthor().getIconInfo())) {
                            arrayList2 = this.eso.ese;
                            if (arrayList2 != null) {
                                MetaData author = lVar.aIr().getAuthor();
                                arrayList3 = this.eso.ese;
                                author.setIconInfo(arrayList3);
                            }
                        }
                    }
                    z2 = this.eso.esi;
                    if (!z2) {
                        for (int i2 = 0; i2 < lVar.aIv().size(); i2++) {
                            boolean equals = str5.equals(lVar.aIv().get(i2).getAuthor().getUserId());
                            tbPageContext = this.eso.aat;
                            lVar.aIv().get(i2).a(tbPageContext, equals);
                        }
                    }
                    if (lVar.aIr() != null) {
                        this.eso.postID = lVar.aIr().getId();
                    }
                    if (lVar.JB() != null) {
                        this.eso.threadID = lVar.JB().getId();
                        this.eso.edS = lVar.nL();
                        this.eso.esb = lVar.JB().rH();
                    }
                    str = this.eso.esb;
                    if (str != null) {
                        str2 = this.eso.postID;
                        if (str2 != null) {
                            str3 = this.eso.esb;
                            str4 = this.eso.postID;
                            if (str3.equals(str4)) {
                                this.eso.edS = true;
                            }
                        }
                    }
                    z3 = this.eso.esi;
                    if (!z3) {
                        this.eso.e(lVar);
                    } else {
                        this.eso.f(lVar);
                    }
                    aVar3 = this.eso.esc;
                    if (aVar3 != null) {
                        boolean z5 = this.eso.aNf();
                        aVar4 = this.eso.esc;
                        lVar2 = this.eso.epO;
                        aVar4.a(z5, error, errorString, lVar2);
                    }
                }
            }
        }
    }
}
