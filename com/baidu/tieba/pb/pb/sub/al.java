package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ak bQB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(ak akVar, int i, int i2) {
        super(i, i2);
        this.bQB = akVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        am amVar;
        am amVar2;
        com.baidu.tieba.pb.a.c cVar;
        String str;
        com.baidu.tieba.pb.a.c cVar2;
        int i;
        int i2;
        int i3;
        com.baidu.tieba.pb.a.c cVar3;
        com.baidu.tieba.pb.a.c cVar4;
        com.baidu.tieba.pb.a.c cVar5;
        am amVar3;
        am amVar4;
        com.baidu.tieba.pb.a.c cVar6;
        String str2;
        String str3;
        String str4;
        NewSubPbActivity newSubPbActivity;
        am amVar5;
        am amVar6;
        long j2;
        long j3;
        int i4;
        com.baidu.tieba.tbadkCore.e.a aVar3;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        com.baidu.tieba.pb.a.c cVar7;
        String errorString;
        NewSubPbActivity newSubPbActivity2;
        NewSubPbActivity newSubPbActivity3;
        NewSubPbActivity newSubPbActivity4;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.bQB.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.bQB.aoe = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    newSubPbActivity4 = this.bQB.bQt;
                    errorString = newSubPbActivity4.getResources().getString(com.baidu.tieba.t.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                newSubPbActivity2 = this.bQB.bQt;
                newSubPbActivity2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    newSubPbActivity3 = this.bQB.bQt;
                    newSubPbActivity3.finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.bQB.b(subPbHttpResponseMessage.pbFloorData);
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
                        this.bQB.b(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.bQB.bQy;
            if (arrayList != null) {
                arrayList2 = this.bQB.bQy;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.bQB.bQy;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.bQB.bQy;
                            cVar7 = this.bQB.bQu;
                            cVar7.b((com.baidu.tieba.pb.a.c) arrayList5.get(size), true);
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.bQB.bQy;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            aVar = this.bQB.aFt;
            if (aVar == null) {
                this.bQB.aFt = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
            }
            aVar2 = this.bQB.aFt;
            if (aVar2 != null) {
                if (error == 0) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        int downSize = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        j2 = j4;
                        j3 = responsedMessage.getCostTime();
                        i4 = downSize;
                    } else if (!(responsedMessage instanceof SubPbSocketResponseMessage)) {
                        j2 = j4;
                        j3 = j;
                        i4 = -1;
                    } else {
                        int downSize2 = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                        j2 = responsedMessage.getCostTime();
                        j3 = j;
                        i4 = downSize2;
                    }
                    aVar3 = this.bQB.aFt;
                    aVar3.a(z, true, error, errorString2, i4, j3, j2);
                    this.bQB.aFt = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
                    this.bQB.aFt = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    amVar = this.bQB.bQv;
                    if (amVar != null) {
                        amVar2 = this.bQB.bQv;
                        amVar2.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        cVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        cVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (cVar.aaA().errorno.intValue() != 0) {
                        amVar5 = this.bQB.bQv;
                        if (amVar5 != null) {
                            amVar6 = this.bQB.bQv;
                            amVar6.a(false, cVar.bJX.errorno.intValue(), cVar.bJX.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (cVar.aaI() != null && cVar.aaI().getAuthor() != null) {
                        str5 = cVar.aaI().getAuthor().getUserId();
                    }
                    for (int i5 = 0; i5 < cVar.aaD().size(); i5++) {
                        boolean equals = str5.equals(cVar.aaD().get(i5).getAuthor().getUserId());
                        newSubPbActivity = this.bQB.bQt;
                        cVar.aaD().get(i5).b(newSubPbActivity.getPageContext(), equals);
                    }
                    if (cVar.aaB() != null) {
                        this.bQB.postID = cVar.aaB().getId();
                    }
                    if (cVar.aaI() != null) {
                        this.bQB.bQn = cVar.aaI().getId();
                        this.bQB.bJW = cVar.pq();
                        this.bQB.bQs = cVar.aaI().ro();
                    }
                    str = this.bQB.bQs;
                    if (str != null) {
                        str2 = this.bQB.postID;
                        if (str2 != null) {
                            str3 = this.bQB.bQs;
                            str4 = this.bQB.postID;
                            if (str3.equals(str4)) {
                                this.bQB.bJW = true;
                            }
                        }
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.j> aaD = cVar.aaD();
                    if (aaD == null || aaD.size() == 0) {
                        cVar2 = this.bQB.bQu;
                        cVar.aJ(cVar2.getCurrentPage());
                    }
                    i = this.bQB.mLoadType;
                    if (i != 1) {
                        i2 = this.bQB.mLoadType;
                        if (i2 != 2) {
                            i3 = this.bQB.mLoadType;
                            if (i3 == 3) {
                                cVar4 = this.bQB.bQu;
                                cVar4.a(cVar, false);
                            } else {
                                cVar3 = this.bQB.bQu;
                                cVar3.b(cVar, false);
                            }
                        } else {
                            cVar5 = this.bQB.bQu;
                            cVar5.b(cVar, true);
                        }
                    } else {
                        this.bQB.bQu = cVar;
                    }
                    amVar3 = this.bQB.bQv;
                    if (amVar3 != null) {
                        boolean z2 = this.bQB.adD();
                        amVar4 = this.bQB.bQv;
                        cVar6 = this.bQB.bQu;
                        amVar4.a(z2, error, errorString2, cVar6);
                    }
                }
            }
        }
    }
}
