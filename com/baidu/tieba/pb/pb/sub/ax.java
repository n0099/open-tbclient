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
    final /* synthetic */ aw dYj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(aw awVar, int i, int i2) {
        super(i, i2);
        this.dYj = awVar;
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
        bdUniqueId = this.dYj.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.dYj.awp = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.dYj.Dp;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(u.j.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.dYj.Dp;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.dYj.Dp;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.dYj.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.dYj.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.dYj.dYb;
            if (arrayList != null) {
                arrayList4 = this.dYj.dYb;
                if (arrayList4.size() > 0) {
                    try {
                        arrayList6 = this.dYj.dYb;
                        for (int size = arrayList6.size() - 1; size >= 0; size--) {
                            arrayList7 = this.dYj.dYb;
                            com.baidu.tieba.pb.data.m mVar5 = (com.baidu.tieba.pb.data.m) arrayList7.get(size);
                            z4 = this.dYj.dYd;
                            if (z4) {
                                mVar4 = this.dYj.dXu;
                                mVar4.c(mVar5, true);
                            } else {
                                mVar3 = this.dYj.dXu;
                                mVar3.b(mVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList5 = this.dYj.dYb;
                    arrayList5.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            bVar = this.dYj.btR;
            if (bVar == null) {
                this.dYj.btR = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.dYj.btR;
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
                    bVar3 = this.dYj.btR;
                    bVar3.a(z, true, error, errorString2, i, j3, j2);
                    this.dYj.btR = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.dYj.btR = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.dYj.dXW;
                    if (aVar != null) {
                        aVar2 = this.dYj.dXW;
                        aVar2.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (mVar.aEd().errorno.intValue() != 0) {
                        aVar5 = this.dYj.dXW;
                        if (aVar5 != null) {
                            aVar6 = this.dYj.dXW;
                            aVar6.a(false, mVar.dMs.errorno.intValue(), mVar.dMs.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (mVar.Ix() != null && mVar.Ix().getAuthor() != null) {
                        str5 = mVar.Ix().getAuthor().getUserId();
                        if (com.baidu.tbadk.core.util.y.t(mVar.aEe().getAuthor().getIconInfo())) {
                            arrayList2 = this.dYj.dXY;
                            if (arrayList2 != null) {
                                MetaData author = mVar.aEe().getAuthor();
                                arrayList3 = this.dYj.dXY;
                                author.setIconInfo(arrayList3);
                            }
                        }
                    }
                    z2 = this.dYj.dYd;
                    if (!z2) {
                        for (int i2 = 0; i2 < mVar.aEi().size(); i2++) {
                            boolean equals = str5.equals(mVar.aEi().get(i2).getAuthor().getUserId());
                            tbPageContext = this.dYj.Dp;
                            mVar.aEi().get(i2).b(tbPageContext, equals);
                        }
                    }
                    if (mVar.aEe() != null) {
                        this.dYj.postID = mVar.aEe().getId();
                    }
                    if (mVar.Ix() != null) {
                        this.dYj.threadID = mVar.Ix().getId();
                        this.dYj.dMr = mVar.mK();
                        this.dYj.dXV = mVar.Ix().qP();
                    }
                    str = this.dYj.dXV;
                    if (str != null) {
                        str2 = this.dYj.postID;
                        if (str2 != null) {
                            str3 = this.dYj.dXV;
                            str4 = this.dYj.postID;
                            if (str3.equals(str4)) {
                                this.dYj.dMr = true;
                            }
                        }
                    }
                    z3 = this.dYj.dYd;
                    if (!z3) {
                        this.dYj.c(mVar);
                    } else {
                        this.dYj.d(mVar);
                    }
                    aVar3 = this.dYj.dXW;
                    if (aVar3 != null) {
                        boolean z5 = this.dYj.aII();
                        aVar4 = this.dYj.dXW;
                        mVar2 = this.dYj.dXu;
                        aVar4.a(z5, error, errorString2, mVar2);
                    }
                }
            }
        }
    }
}
