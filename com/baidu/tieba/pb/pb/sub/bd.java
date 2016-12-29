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
    final /* synthetic */ bc ejM;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(bc bcVar, int i, int i2) {
        super(i, i2);
        this.ejM = bcVar;
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
        com.baidu.tieba.pb.data.j jVar;
        boolean z2;
        String str;
        boolean z3;
        bc.a aVar3;
        bc.a aVar4;
        com.baidu.tieba.pb.data.j jVar2;
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
        com.baidu.tieba.pb.data.j jVar3;
        com.baidu.tieba.pb.data.j jVar4;
        TbPageContext tbPageContext2;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.ejM.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.ejM.aAd = false;
            if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                tbPageContext2 = this.ejM.Gf;
                tbPageContext2.getPageActivity().finish();
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.ejM.f(subPbHttpResponseMessage.pbFloorData);
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
                        this.ejM.f(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.ejM.ejE;
            if (arrayList != null) {
                arrayList4 = this.ejM.ejE;
                if (arrayList4.size() > 0) {
                    try {
                        arrayList6 = this.ejM.ejE;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            arrayList7 = this.ejM.ejE;
                            com.baidu.tieba.pb.data.j jVar5 = (com.baidu.tieba.pb.data.j) arrayList7.get(size);
                            z4 = this.ejM.ejG;
                            if (z4) {
                                jVar4 = this.ejM.ehB;
                                jVar4.c(jVar5, true);
                            } else {
                                jVar3 = this.ejM.ehB;
                                jVar3.b(jVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList5 = this.ejM.ejE;
                    arrayList5.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            bVar = this.ejM.bqy;
            if (bVar == null) {
                this.ejM.bqy = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.ejM.bqy;
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
                    bVar3 = this.ejM.bqy;
                    bVar3.a(z, true, error, errorString, i, j3, j2);
                    this.ejM.bqy = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.ejM.bqy = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.ejM.ejA;
                    if (aVar != null) {
                        aVar2 = this.ejM.ejA;
                        aVar2.a(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (jVar.aIE().errorno.intValue() != 0) {
                        aVar5 = this.ejM.ejA;
                        if (aVar5 != null) {
                            aVar6 = this.ejM.ejA;
                            aVar6.a(false, jVar.dXd.errorno.intValue(), jVar.dXd.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (jVar.IU() != null && jVar.IU().getAuthor() != null) {
                        str5 = jVar.IU().getAuthor().getUserId();
                        if (com.baidu.tbadk.core.util.x.t(jVar.aIF().getAuthor().getIconInfo())) {
                            arrayList2 = this.ejM.ejC;
                            if (arrayList2 != null) {
                                MetaData author = jVar.aIF().getAuthor();
                                arrayList3 = this.ejM.ejC;
                                author.setIconInfo(arrayList3);
                            }
                        }
                    }
                    z2 = this.ejM.ejG;
                    if (!z2) {
                        for (int i2 = 0; i2 < jVar.aIJ().size(); i2++) {
                            boolean equals = str5.equals(jVar.aIJ().get(i2).getAuthor().getUserId());
                            tbPageContext = this.ejM.Gf;
                            jVar.aIJ().get(i2).b(tbPageContext, equals);
                        }
                    }
                    if (jVar.aIF() != null) {
                        this.ejM.postID = jVar.aIF().getId();
                    }
                    if (jVar.IU() != null) {
                        this.ejM.threadID = jVar.IU().getId();
                        this.ejM.dXc = jVar.nz();
                        this.ejM.ejz = jVar.IU().rO();
                    }
                    str = this.ejM.ejz;
                    if (str != null) {
                        str2 = this.ejM.postID;
                        if (str2 != null) {
                            str3 = this.ejM.ejz;
                            str4 = this.ejM.postID;
                            if (str3.equals(str4)) {
                                this.ejM.dXc = true;
                            }
                        }
                    }
                    z3 = this.ejM.ejG;
                    if (!z3) {
                        this.ejM.d(jVar);
                    } else {
                        this.ejM.e(jVar);
                    }
                    aVar3 = this.ejM.ejA;
                    if (aVar3 != null) {
                        boolean z5 = this.ejM.aNs();
                        aVar4 = this.ejM.ejA;
                        jVar2 = this.ejM.ehB;
                        aVar4.a(z5, error, errorString, jVar2);
                    }
                }
            }
        }
    }
}
