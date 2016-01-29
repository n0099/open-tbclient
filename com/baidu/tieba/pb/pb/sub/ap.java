package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.sub.ao;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ao cUU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap(ao aoVar, int i, int i2) {
        super(i, i2);
        this.cUU = aoVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.d.b bVar;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        ao.a aVar;
        ao.a aVar2;
        com.baidu.tieba.pb.a.d dVar;
        boolean z2;
        String str;
        boolean z3;
        ao.a aVar3;
        ao.a aVar4;
        com.baidu.tieba.pb.a.d dVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ao.a aVar5;
        ao.a aVar6;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.tbadkCore.d.b bVar3;
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
        bdUniqueId = this.cUU.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.cUU.ayQ = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.cUU.MR;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(t.j.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.cUU.MR;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.cUU.MR;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.cUU.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.cUU.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.cUU.cUM;
            if (arrayList != null) {
                arrayList2 = this.cUU.cUM;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.cUU.cUM;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.cUU.cUM;
                            com.baidu.tieba.pb.a.d dVar5 = (com.baidu.tieba.pb.a.d) arrayList5.get(size);
                            z4 = this.cUU.cUO;
                            if (z4) {
                                dVar4 = this.cUU.cUj;
                                dVar4.c(dVar5, true);
                            } else {
                                dVar3 = this.cUU.cUj;
                                dVar3.b(dVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.cUU.cUM;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            bVar = this.cUU.aXf;
            if (bVar == null) {
                this.cUU.aXf = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.cUU.aXf;
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
                    bVar3 = this.cUU.aXf;
                    bVar3.a(z, true, error, errorString2, i, j3, j2);
                    this.cUU.aXf = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.cUU.aXf = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.cUU.cUI;
                    if (aVar != null) {
                        aVar2 = this.cUU.cUI;
                        aVar2.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        dVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        dVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (dVar.aoP().errorno.intValue() != 0) {
                        aVar5 = this.cUU.cUI;
                        if (aVar5 != null) {
                            aVar6 = this.cUU.cUI;
                            aVar6.a(false, dVar.cJO.errorno.intValue(), dVar.cJO.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (dVar.Ki() != null && dVar.Ki().getAuthor() != null) {
                        str5 = dVar.Ki().getAuthor().getUserId();
                    }
                    z2 = this.cUU.cUO;
                    if (!z2) {
                        for (int i2 = 0; i2 < dVar.aoU().size(); i2++) {
                            boolean equals = str5.equals(dVar.aoU().get(i2).getAuthor().getUserId());
                            tbPageContext = this.cUU.MR;
                            dVar.aoU().get(i2).a(tbPageContext.getUniqueId(), equals);
                        }
                    }
                    if (dVar.aoQ() != null) {
                        this.cUU.postID = dVar.aoQ().getId();
                    }
                    if (dVar.Ki() != null) {
                        this.cUU.threadID = dVar.Ki().getId();
                        this.cUU.cJN = dVar.qg();
                        this.cUU.cUH = dVar.Ki().ts();
                    }
                    str = this.cUU.cUH;
                    if (str != null) {
                        str2 = this.cUU.postID;
                        if (str2 != null) {
                            str3 = this.cUU.cUH;
                            str4 = this.cUU.postID;
                            if (str3.equals(str4)) {
                                this.cUU.cJN = true;
                            }
                        }
                    }
                    z3 = this.cUU.cUO;
                    if (!z3) {
                        this.cUU.c(dVar);
                    } else {
                        this.cUU.d(dVar);
                    }
                    aVar3 = this.cUU.cUI;
                    if (aVar3 != null) {
                        boolean z5 = this.cUU.asx();
                        aVar4 = this.cUU.cUI;
                        dVar2 = this.cUU.cUj;
                        aVar4.a(z5, error, errorString2, dVar2);
                    }
                }
            }
        }
    }
}
