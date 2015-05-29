package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ak bQA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(ak akVar, int i, int i2) {
        super(i, i2);
        this.bQA = akVar;
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
        bdUniqueId = this.bQA.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.bQA.aoe = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    newSubPbActivity4 = this.bQA.bQs;
                    errorString = newSubPbActivity4.getResources().getString(com.baidu.tieba.t.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                newSubPbActivity2 = this.bQA.bQs;
                newSubPbActivity2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    newSubPbActivity3 = this.bQA.bQs;
                    newSubPbActivity3.finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.bQA.b(subPbHttpResponseMessage.pbFloorData);
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
                        this.bQA.b(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.bQA.bQx;
            if (arrayList != null) {
                arrayList2 = this.bQA.bQx;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.bQA.bQx;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.bQA.bQx;
                            cVar7 = this.bQA.bQt;
                            cVar7.b((com.baidu.tieba.pb.a.c) arrayList5.get(size), true);
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.bQA.bQx;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            aVar = this.bQA.aFs;
            if (aVar == null) {
                this.bQA.aFs = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
            }
            aVar2 = this.bQA.aFs;
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
                    aVar3 = this.bQA.aFs;
                    aVar3.a(z, true, error, errorString2, i4, j3, j2);
                    this.bQA.aFs = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
                    this.bQA.aFs = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    amVar = this.bQA.bQu;
                    if (amVar != null) {
                        amVar2 = this.bQA.bQu;
                        amVar2.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        cVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        cVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (cVar.aaz().errorno.intValue() != 0) {
                        amVar5 = this.bQA.bQu;
                        if (amVar5 != null) {
                            amVar6 = this.bQA.bQu;
                            amVar6.a(false, cVar.bJW.errorno.intValue(), cVar.bJW.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (cVar.aaH() != null && cVar.aaH().getAuthor() != null) {
                        str5 = cVar.aaH().getAuthor().getUserId();
                    }
                    for (int i5 = 0; i5 < cVar.aaC().size(); i5++) {
                        boolean equals = str5.equals(cVar.aaC().get(i5).getAuthor().getUserId());
                        newSubPbActivity = this.bQA.bQs;
                        cVar.aaC().get(i5).b(newSubPbActivity.getPageContext(), equals);
                    }
                    if (cVar.aaA() != null) {
                        this.bQA.postID = cVar.aaA().getId();
                    }
                    if (cVar.aaH() != null) {
                        this.bQA.bQm = cVar.aaH().getId();
                        this.bQA.bJV = cVar.pq();
                        this.bQA.bQr = cVar.aaH().ro();
                    }
                    str = this.bQA.bQr;
                    if (str != null) {
                        str2 = this.bQA.postID;
                        if (str2 != null) {
                            str3 = this.bQA.bQr;
                            str4 = this.bQA.postID;
                            if (str3.equals(str4)) {
                                this.bQA.bJV = true;
                            }
                        }
                    }
                    ArrayList<com.baidu.tieba.tbadkCore.data.j> aaC = cVar.aaC();
                    if (aaC == null || aaC.size() == 0) {
                        cVar2 = this.bQA.bQt;
                        cVar.aJ(cVar2.getCurrentPage());
                    }
                    i = this.bQA.mLoadType;
                    if (i != 1) {
                        i2 = this.bQA.mLoadType;
                        if (i2 != 2) {
                            i3 = this.bQA.mLoadType;
                            if (i3 == 3) {
                                cVar4 = this.bQA.bQt;
                                cVar4.a(cVar, false);
                            } else {
                                cVar3 = this.bQA.bQt;
                                cVar3.b(cVar, false);
                            }
                        } else {
                            cVar5 = this.bQA.bQt;
                            cVar5.b(cVar, true);
                        }
                    } else {
                        this.bQA.bQt = cVar;
                    }
                    amVar3 = this.bQA.bQu;
                    if (amVar3 != null) {
                        boolean z2 = this.bQA.adC();
                        amVar4 = this.bQA.bQu;
                        cVar6 = this.bQA.bQt;
                        amVar4.a(z2, error, errorString2, cVar6);
                    }
                }
            }
        }
    }
}
