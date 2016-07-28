package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.pb.pb.sub.aw;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ aw ekL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(aw awVar, int i, int i2) {
        super(i, i2);
        this.ekL = awVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.d.b bVar;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        aw.a aVar;
        aw.a aVar2;
        com.baidu.tieba.pb.data.m mVar;
        boolean z2;
        String str;
        boolean z3;
        aw.a aVar3;
        aw.a aVar4;
        com.baidu.tieba.pb.data.m mVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ArrayList arrayList2;
        ArrayList<IconData> arrayList3;
        aw.a aVar5;
        aw.a aVar6;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.tbadkCore.d.b bVar3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        boolean z4;
        com.baidu.tieba.pb.data.m mVar3;
        com.baidu.tieba.pb.data.m mVar4;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.ekL.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.ekL.axe = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.ekL.DQ;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(u.j.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.ekL.DQ;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.ekL.DQ;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.ekL.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.ekL.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.ekL.ekD;
            if (arrayList != null) {
                arrayList4 = this.ekL.ekD;
                if (arrayList4.size() > 0) {
                    try {
                        arrayList6 = this.ekL.ekD;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            arrayList7 = this.ekL.ekD;
                            com.baidu.tieba.pb.data.m mVar5 = (com.baidu.tieba.pb.data.m) arrayList7.get(size);
                            z4 = this.ekL.ekF;
                            if (z4) {
                                mVar4 = this.ekL.ejW;
                                mVar4.c(mVar5, true);
                            } else {
                                mVar3 = this.ekL.ejW;
                                mVar3.b(mVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList5 = this.ekL.ekD;
                    arrayList5.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            bVar = this.ekL.bwf;
            if (bVar == null) {
                this.ekL.bwf = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.ekL.bwf;
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
                    bVar3 = this.ekL.bwf;
                    bVar3.a(z, true, error, errorString2, i, j3, j2);
                    this.ekL.bwf = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.ekL.bwf = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.ekL.eky;
                    if (aVar != null) {
                        aVar2 = this.ekL.eky;
                        aVar2.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (mVar.aHo().errorno.intValue() != 0) {
                        aVar5 = this.ekL.eky;
                        if (aVar5 != null) {
                            aVar6 = this.ekL.eky;
                            aVar6.a(false, mVar.dYC.errorno.intValue(), mVar.dYC.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (mVar.Iw() != null && mVar.Iw().getAuthor() != null) {
                        str5 = mVar.Iw().getAuthor().getUserId();
                        if (com.baidu.tbadk.core.util.y.t(mVar.aHp().getAuthor().getIconInfo())) {
                            arrayList2 = this.ekL.ekA;
                            if (arrayList2 != null) {
                                MetaData author = mVar.aHp().getAuthor();
                                arrayList3 = this.ekL.ekA;
                                author.setIconInfo(arrayList3);
                            }
                        }
                    }
                    z2 = this.ekL.ekF;
                    if (!z2) {
                        for (int i2 = 0; i2 < mVar.aHt().size(); i2++) {
                            boolean equals = str5.equals(mVar.aHt().get(i2).getAuthor().getUserId());
                            tbPageContext = this.ekL.DQ;
                            mVar.aHt().get(i2).b(tbPageContext, equals);
                        }
                    }
                    if (mVar.aHp() != null) {
                        this.ekL.postID = mVar.aHp().getId();
                    }
                    if (mVar.Iw() != null) {
                        this.ekL.threadID = mVar.Iw().getId();
                        this.ekL.dYB = mVar.mA();
                        this.ekL.ekx = mVar.Iw().qE();
                    }
                    str = this.ekL.ekx;
                    if (str != null) {
                        str2 = this.ekL.postID;
                        if (str2 != null) {
                            str3 = this.ekL.ekx;
                            str4 = this.ekL.postID;
                            if (str3.equals(str4)) {
                                this.ekL.dYB = true;
                            }
                        }
                    }
                    z3 = this.ekL.ekF;
                    if (!z3) {
                        this.ekL.c(mVar);
                    } else {
                        this.ekL.d(mVar);
                    }
                    aVar3 = this.ekL.eky;
                    if (aVar3 != null) {
                        boolean z5 = this.ekL.aLT();
                        aVar4 = this.ekL.eky;
                        mVar2 = this.ekL.ejW;
                        aVar4.a(z5, error, errorString2, mVar2);
                    }
                }
            }
        }
    }
}
