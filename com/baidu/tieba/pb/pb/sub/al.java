package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.sub.ak;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ak chW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(ak akVar, int i, int i2) {
        super(i, i2);
        this.chW = akVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        ak.a aVar3;
        ak.a aVar4;
        com.baidu.tieba.pb.a.c cVar;
        boolean z2;
        String str;
        boolean z3;
        ak.a aVar5;
        ak.a aVar6;
        com.baidu.tieba.pb.a.c cVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ak.a aVar7;
        ak.a aVar8;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.tbadkCore.e.a aVar9;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        boolean z4;
        com.baidu.tieba.pb.a.c cVar3;
        com.baidu.tieba.pb.a.c cVar4;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.chW.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.chW.axc = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.chW.mContext;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(i.h.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.chW.mContext;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.chW.mContext;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.chW.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.chW.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.chW.chR;
            if (arrayList != null) {
                arrayList2 = this.chW.chR;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.chW.chR;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.chW.chR;
                            com.baidu.tieba.pb.a.c cVar5 = (com.baidu.tieba.pb.a.c) arrayList5.get(size);
                            z4 = this.chW.chT;
                            if (z4) {
                                cVar4 = this.chW.cho;
                                cVar4.c(cVar5, true);
                            } else {
                                cVar3 = this.chW.cho;
                                cVar3.b(cVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.chW.chR;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            aVar = this.chW.aNf;
            if (aVar == null) {
                this.chW.aNf = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
            }
            aVar2 = this.chW.aNf;
            if (aVar2 != null) {
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
                    aVar9 = this.chW.aNf;
                    aVar9.a(z, true, error, errorString2, i, j3, j2);
                    this.chW.aNf = new com.baidu.tieba.tbadkCore.e.a("pbfloorStat");
                    this.chW.aNf = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar3 = this.chW.chO;
                    if (aVar3 != null) {
                        aVar4 = this.chW.chO;
                        aVar4.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        cVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        cVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (cVar.ada().errorno.intValue() != 0) {
                        aVar7 = this.chW.chO;
                        if (aVar7 != null) {
                            aVar8 = this.chW.chO;
                            aVar8.a(false, cVar.cbl.errorno.intValue(), cVar.cbl.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (cVar.adk() != null && cVar.adk().getAuthor() != null) {
                        str5 = cVar.adk().getAuthor().getUserId();
                    }
                    z2 = this.chW.chT;
                    if (!z2) {
                        for (int i2 = 0; i2 < cVar.adf().size(); i2++) {
                            boolean equals = str5.equals(cVar.adf().get(i2).getAuthor().getUserId());
                            tbPageContext = this.chW.mContext;
                            cVar.adf().get(i2).a(tbPageContext.getUniqueId(), equals);
                        }
                    }
                    if (cVar.adb() != null) {
                        this.chW.postID = cVar.adb().getId();
                    }
                    if (cVar.adk() != null) {
                        this.chW.threadID = cVar.adk().getId();
                        this.chW.cbk = cVar.qo();
                        this.chW.chN = cVar.adk().ss();
                    }
                    str = this.chW.chN;
                    if (str != null) {
                        str2 = this.chW.postID;
                        if (str2 != null) {
                            str3 = this.chW.chN;
                            str4 = this.chW.postID;
                            if (str3.equals(str4)) {
                                this.chW.cbk = true;
                            }
                        }
                    }
                    z3 = this.chW.chT;
                    if (!z3) {
                        this.chW.c(cVar);
                    } else {
                        this.chW.d(cVar);
                    }
                    aVar5 = this.chW.chO;
                    if (aVar5 != null) {
                        boolean z5 = this.chW.afE();
                        aVar6 = this.chW.chO;
                        cVar2 = this.chW.cho;
                        aVar6.a(z5, error, errorString2, cVar2);
                    }
                }
            }
        }
    }
}
