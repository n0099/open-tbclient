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
    final /* synthetic */ SubPbModel eup;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(SubPbModel subPbModel, int i, int i2) {
        super(i, i2);
        this.eup = subPbModel;
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
        com.baidu.tieba.pb.data.j jVar;
        boolean z2;
        String str;
        boolean z3;
        SubPbModel.a aVar3;
        SubPbModel.a aVar4;
        com.baidu.tieba.pb.data.j jVar2;
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
        com.baidu.tieba.pb.data.j jVar3;
        com.baidu.tieba.pb.data.j jVar4;
        TbPageContext tbPageContext2;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.eup.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.eup.isLoading = false;
            if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                tbPageContext2 = this.eup.aaX;
                tbPageContext2.getPageActivity().finish();
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.eup.f(subPbHttpResponseMessage.pbFloorData);
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
                        this.eup.f(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.eup.euh;
            if (arrayList != null) {
                arrayList4 = this.eup.euh;
                if (arrayList4.size() > 0) {
                    try {
                        arrayList6 = this.eup.euh;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            arrayList7 = this.eup.euh;
                            com.baidu.tieba.pb.data.j jVar5 = (com.baidu.tieba.pb.data.j) arrayList7.get(size);
                            z4 = this.eup.euj;
                            if (z4) {
                                jVar4 = this.eup.erT;
                                jVar4.c(jVar5, true);
                            } else {
                                jVar3 = this.eup.erT;
                                jVar3.b(jVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList5 = this.eup.euh;
                    arrayList5.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            bVar = this.eup.bFk;
            if (bVar == null) {
                this.eup.bFk = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.eup.bFk;
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
                    bVar3 = this.eup.bFk;
                    bVar3.a(z, true, error, errorString, i, j3, j2);
                    this.eup.bFk = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.eup.bFk = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.eup.eud;
                    if (aVar != null) {
                        aVar2 = this.eup.eud;
                        aVar2.a(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (jVar.aJU().errorno.intValue() != 0) {
                        aVar5 = this.eup.eud;
                        if (aVar5 != null) {
                            aVar6 = this.eup.eud;
                            aVar6.a(false, jVar.egC.errorno.intValue(), jVar.egC.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (jVar.Kn() != null && jVar.Kn().getAuthor() != null) {
                        str5 = jVar.Kn().getAuthor().getUserId();
                        if (com.baidu.tbadk.core.util.x.q(jVar.aJV().getAuthor().getIconInfo())) {
                            arrayList2 = this.eup.euf;
                            if (arrayList2 != null) {
                                MetaData author = jVar.aJV().getAuthor();
                                arrayList3 = this.eup.euf;
                                author.setIconInfo(arrayList3);
                            }
                        }
                    }
                    z2 = this.eup.euj;
                    if (!z2) {
                        for (int i2 = 0; i2 < jVar.aJZ().size(); i2++) {
                            boolean equals = str5.equals(jVar.aJZ().get(i2).getAuthor().getUserId());
                            tbPageContext = this.eup.aaX;
                            jVar.aJZ().get(i2).b(tbPageContext, equals);
                        }
                    }
                    if (jVar.aJV() != null) {
                        this.eup.postID = jVar.aJV().getId();
                    }
                    if (jVar.Kn() != null) {
                        this.eup.threadID = jVar.Kn().getId();
                        this.eup.egB = jVar.oe();
                        this.eup.euc = jVar.Kn().sx();
                    }
                    str = this.eup.euc;
                    if (str != null) {
                        str2 = this.eup.postID;
                        if (str2 != null) {
                            str3 = this.eup.euc;
                            str4 = this.eup.postID;
                            if (str3.equals(str4)) {
                                this.eup.egB = true;
                            }
                        }
                    }
                    z3 = this.eup.euj;
                    if (!z3) {
                        this.eup.d(jVar);
                    } else {
                        this.eup.e(jVar);
                    }
                    aVar3 = this.eup.eud;
                    if (aVar3 != null) {
                        boolean z5 = this.eup.aOO();
                        aVar4 = this.eup.eud;
                        jVar2 = this.eup.erT;
                        aVar4.a(z5, error, errorString, jVar2);
                    }
                }
            }
        }
    }
}
