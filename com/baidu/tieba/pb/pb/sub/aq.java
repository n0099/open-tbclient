package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.pb.pb.sub.ap;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ap dry;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ap apVar, int i, int i2) {
        super(i, i2);
        this.dry = apVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.d.b bVar;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        ap.a aVar;
        ap.a aVar2;
        com.baidu.tieba.pb.data.h hVar;
        boolean z2;
        String str;
        boolean z3;
        ap.a aVar3;
        ap.a aVar4;
        com.baidu.tieba.pb.data.h hVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ArrayList arrayList2;
        ArrayList<IconData> arrayList3;
        ap.a aVar5;
        ap.a aVar6;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.tbadkCore.d.b bVar3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        boolean z4;
        com.baidu.tieba.pb.data.h hVar3;
        com.baidu.tieba.pb.data.h hVar4;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.dry.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.dry.avz = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.dry.Do;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(t.j.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.dry.Do;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.dry.Do;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.dry.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.dry.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.dry.drq;
            if (arrayList != null) {
                arrayList4 = this.dry.drq;
                if (arrayList4.size() > 0) {
                    try {
                        arrayList6 = this.dry.drq;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            arrayList7 = this.dry.drq;
                            com.baidu.tieba.pb.data.h hVar5 = (com.baidu.tieba.pb.data.h) arrayList7.get(size);
                            z4 = this.dry.drs;
                            if (z4) {
                                hVar4 = this.dry.dqL;
                                hVar4.c(hVar5, true);
                            } else {
                                hVar3 = this.dry.dqL;
                                hVar3.b(hVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList5 = this.dry.drq;
                    arrayList5.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            bVar = this.dry.aXX;
            if (bVar == null) {
                this.dry.aXX = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.dry.aXX;
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
                    bVar3 = this.dry.aXX;
                    bVar3.a(z, true, error, errorString2, i, j3, j2);
                    this.dry.aXX = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.dry.aXX = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.dry.drl;
                    if (aVar != null) {
                        aVar2 = this.dry.drl;
                        aVar2.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        hVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        hVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (hVar.avN().errorno.intValue() != 0) {
                        aVar5 = this.dry.drl;
                        if (aVar5 != null) {
                            aVar6 = this.dry.drl;
                            aVar6.a(false, hVar.dfz.errorno.intValue(), hVar.dfz.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (hVar.Kl() != null && hVar.Kl().getAuthor() != null) {
                        str5 = hVar.Kl().getAuthor().getUserId();
                        if (com.baidu.tbadk.core.util.y.s(hVar.avO().getAuthor().getIconInfo())) {
                            arrayList2 = this.dry.drn;
                            if (arrayList2 != null) {
                                MetaData author = hVar.avO().getAuthor();
                                arrayList3 = this.dry.drn;
                                author.setIconInfo(arrayList3);
                            }
                        }
                    }
                    z2 = this.dry.drs;
                    if (!z2) {
                        for (int i2 = 0; i2 < hVar.avS().size(); i2++) {
                            boolean equals = str5.equals(hVar.avS().get(i2).getAuthor().getUserId());
                            tbPageContext = this.dry.Do;
                            hVar.avS().get(i2).b(tbPageContext, equals);
                        }
                    }
                    if (hVar.avO() != null) {
                        this.dry.postID = hVar.avO().getId();
                    }
                    if (hVar.Kl() != null) {
                        this.dry.threadID = hVar.Kl().getId();
                        this.dry.dfy = hVar.mP();
                        this.dry.drk = hVar.Kl().qT();
                    }
                    str = this.dry.drk;
                    if (str != null) {
                        str2 = this.dry.postID;
                        if (str2 != null) {
                            str3 = this.dry.drk;
                            str4 = this.dry.postID;
                            if (str3.equals(str4)) {
                                this.dry.dfy = true;
                            }
                        }
                    }
                    z3 = this.dry.drs;
                    if (!z3) {
                        this.dry.c(hVar);
                    } else {
                        this.dry.d(hVar);
                    }
                    aVar3 = this.dry.drl;
                    if (aVar3 != null) {
                        boolean z5 = this.dry.aAo();
                        aVar4 = this.dry.drl;
                        hVar2 = this.dry.dqL;
                        aVar4.a(z5, error, errorString2, hVar2);
                    }
                }
            }
        }
    }
}
