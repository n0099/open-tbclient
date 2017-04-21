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
    final /* synthetic */ SubPbModel ewF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(SubPbModel subPbModel, int i, int i2) {
        super(i, i2);
        this.ewF = subPbModel;
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
        bdUniqueId = this.ewF.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.ewF.isLoading = false;
            if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                tbPageContext2 = this.ewF.aaY;
                tbPageContext2.getPageActivity().finish();
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.ewF.f(subPbHttpResponseMessage.pbFloorData);
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
                        this.ewF.f(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.ewF.ewx;
            if (arrayList != null) {
                arrayList4 = this.ewF.ewx;
                if (arrayList4.size() > 0) {
                    try {
                        arrayList6 = this.ewF.ewx;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            arrayList7 = this.ewF.ewx;
                            com.baidu.tieba.pb.data.j jVar5 = (com.baidu.tieba.pb.data.j) arrayList7.get(size);
                            z4 = this.ewF.ewz;
                            if (z4) {
                                jVar4 = this.ewF.eul;
                                jVar4.c(jVar5, true);
                            } else {
                                jVar3 = this.ewF.eul;
                                jVar3.b(jVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList5 = this.ewF.ewx;
                    arrayList5.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            bVar = this.ewF.bHB;
            if (bVar == null) {
                this.ewF.bHB = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.ewF.bHB;
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
                    bVar3 = this.ewF.bHB;
                    bVar3.a(z, true, error, errorString, i, j3, j2);
                    this.ewF.bHB = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.ewF.bHB = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.ewF.ewt;
                    if (aVar != null) {
                        aVar2 = this.ewF.ewt;
                        aVar2.a(false, error, errorString, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (jVar.aKV().errorno.intValue() != 0) {
                        aVar5 = this.ewF.ewt;
                        if (aVar5 != null) {
                            aVar6 = this.ewF.ewt;
                            aVar6.a(false, jVar.eiS.errorno.intValue(), jVar.eiS.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (jVar.Kn() != null && jVar.Kn().getAuthor() != null) {
                        str5 = jVar.Kn().getAuthor().getUserId();
                        if (com.baidu.tbadk.core.util.x.q(jVar.aKW().getAuthor().getIconInfo())) {
                            arrayList2 = this.ewF.ewv;
                            if (arrayList2 != null) {
                                MetaData author = jVar.aKW().getAuthor();
                                arrayList3 = this.ewF.ewv;
                                author.setIconInfo(arrayList3);
                            }
                        }
                    }
                    z2 = this.ewF.ewz;
                    if (!z2) {
                        for (int i2 = 0; i2 < jVar.aLa().size(); i2++) {
                            boolean equals = str5.equals(jVar.aLa().get(i2).getAuthor().getUserId());
                            tbPageContext = this.ewF.aaY;
                            jVar.aLa().get(i2).b(tbPageContext, equals);
                        }
                    }
                    if (jVar.aKW() != null) {
                        this.ewF.postID = jVar.aKW().getId();
                    }
                    if (jVar.Kn() != null) {
                        this.ewF.threadID = jVar.Kn().getId();
                        this.ewF.eiR = jVar.oe();
                        this.ewF.ews = jVar.Kn().sx();
                    }
                    str = this.ewF.ews;
                    if (str != null) {
                        str2 = this.ewF.postID;
                        if (str2 != null) {
                            str3 = this.ewF.ews;
                            str4 = this.ewF.postID;
                            if (str3.equals(str4)) {
                                this.ewF.eiR = true;
                            }
                        }
                    }
                    z3 = this.ewF.ewz;
                    if (!z3) {
                        this.ewF.d(jVar);
                    } else {
                        this.ewF.e(jVar);
                    }
                    aVar3 = this.ewF.ewt;
                    if (aVar3 != null) {
                        boolean z5 = this.ewF.aPP();
                        aVar4 = this.ewF.ewt;
                        jVar2 = this.ewF.eul;
                        aVar4.a(z5, error, errorString, jVar2);
                    }
                }
            }
        }
    }
}
