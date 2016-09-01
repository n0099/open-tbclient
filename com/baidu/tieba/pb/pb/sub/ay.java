package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.pb.pb.sub.ax;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ax ewT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(ax axVar, int i, int i2) {
        super(i, i2);
        this.ewT = axVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        long j;
        boolean z;
        ArrayList arrayList;
        com.baidu.tieba.tbadkCore.d.b bVar;
        com.baidu.tieba.tbadkCore.d.b bVar2;
        ax.a aVar;
        ax.a aVar2;
        com.baidu.tieba.pb.data.m mVar;
        boolean z2;
        String str;
        boolean z3;
        ax.a aVar3;
        ax.a aVar4;
        com.baidu.tieba.pb.data.m mVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ArrayList arrayList2;
        ArrayList<IconData> arrayList3;
        ax.a aVar5;
        ax.a aVar6;
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
        bdUniqueId = this.ewT.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.ewT.aAl = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.ewT.Gd;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(t.j.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.ewT.Gd;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.ewT.Gd;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.ewT.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.ewT.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.ewT.ewL;
            if (arrayList != null) {
                arrayList4 = this.ewT.ewL;
                if (arrayList4.size() > 0) {
                    try {
                        arrayList6 = this.ewT.ewL;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            arrayList7 = this.ewT.ewL;
                            com.baidu.tieba.pb.data.m mVar5 = (com.baidu.tieba.pb.data.m) arrayList7.get(size);
                            z4 = this.ewT.ewN;
                            if (z4) {
                                mVar4 = this.ewT.ewe;
                                mVar4.c(mVar5, true);
                            } else {
                                mVar3 = this.ewT.ewe;
                                mVar3.b(mVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList5 = this.ewT.ewL;
                    arrayList5.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            bVar = this.ewT.bHt;
            if (bVar == null) {
                this.ewT.bHt = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.ewT.bHt;
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
                    bVar3 = this.ewT.bHt;
                    bVar3.a(z, true, error, errorString2, i, j3, j2);
                    this.ewT.bHt = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.ewT.bHt = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.ewT.ewG;
                    if (aVar != null) {
                        aVar2 = this.ewT.ewG;
                        aVar2.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (mVar.aMg().errorno.intValue() != 0) {
                        aVar5 = this.ewT.ewG;
                        if (aVar5 != null) {
                            aVar6 = this.ewT.ewG;
                            aVar6.a(false, mVar.ekG.errorno.intValue(), mVar.ekG.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (mVar.Kw() != null && mVar.Kw().getAuthor() != null) {
                        str5 = mVar.Kw().getAuthor().getUserId();
                        if (com.baidu.tbadk.core.util.y.t(mVar.aMh().getAuthor().getIconInfo())) {
                            arrayList2 = this.ewT.ewI;
                            if (arrayList2 != null) {
                                MetaData author = mVar.aMh().getAuthor();
                                arrayList3 = this.ewT.ewI;
                                author.setIconInfo(arrayList3);
                            }
                        }
                    }
                    z2 = this.ewT.ewN;
                    if (!z2) {
                        for (int i2 = 0; i2 < mVar.aMl().size(); i2++) {
                            boolean equals = str5.equals(mVar.aMl().get(i2).getAuthor().getUserId());
                            tbPageContext = this.ewT.Gd;
                            mVar.aMl().get(i2).c(tbPageContext, equals);
                        }
                    }
                    if (mVar.aMh() != null) {
                        this.ewT.postID = mVar.aMh().getId();
                    }
                    if (mVar.Kw() != null) {
                        this.ewT.threadID = mVar.Kw().getId();
                        this.ewT.ekF = mVar.nv();
                        this.ewT.ewF = mVar.Kw().rJ();
                    }
                    str = this.ewT.ewF;
                    if (str != null) {
                        str2 = this.ewT.postID;
                        if (str2 != null) {
                            str3 = this.ewT.ewF;
                            str4 = this.ewT.postID;
                            if (str3.equals(str4)) {
                                this.ewT.ekF = true;
                            }
                        }
                    }
                    z3 = this.ewT.ewN;
                    if (!z3) {
                        this.ewT.c(mVar);
                    } else {
                        this.ewT.d(mVar);
                    }
                    aVar3 = this.ewT.ewG;
                    if (aVar3 != null) {
                        boolean z5 = this.ewT.aQL();
                        aVar4 = this.ewT.ewG;
                        mVar2 = this.ewT.ewe;
                        aVar4.a(z5, error, errorString2, mVar2);
                    }
                }
            }
        }
    }
}
