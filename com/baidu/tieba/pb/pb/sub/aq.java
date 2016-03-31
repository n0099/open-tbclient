package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.pb.pb.sub.ap;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ap dpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aq(ap apVar, int i, int i2) {
        super(i, i2);
        this.dpP = apVar;
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
        com.baidu.tieba.pb.data.g gVar;
        boolean z2;
        String str;
        boolean z3;
        ap.a aVar3;
        ap.a aVar4;
        com.baidu.tieba.pb.data.g gVar2;
        String str2;
        String str3;
        String str4;
        TbPageContext tbPageContext;
        ap.a aVar5;
        ap.a aVar6;
        long j2;
        long j3;
        int i;
        com.baidu.tieba.tbadkCore.d.b bVar3;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        boolean z4;
        com.baidu.tieba.pb.data.g gVar3;
        com.baidu.tieba.pb.data.g gVar4;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        long j4 = 0;
        String str5 = null;
        bdUniqueId = this.dpP.unique_id;
        if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
            this.dpP.azx = false;
            if (responsedMessage.hasError()) {
                if (StringUtils.isNull(responsedMessage.getErrorString())) {
                    tbPageContext4 = this.dpP.MX;
                    errorString = tbPageContext4.getPageActivity().getResources().getString(t.j.neterror);
                } else {
                    errorString = responsedMessage.getErrorString();
                }
                tbPageContext2 = this.dpP.MX;
                tbPageContext2.showToast(errorString);
                if (responsedMessage.getError() == 4) {
                    tbPageContext3 = this.dpP.MX;
                    tbPageContext3.getPageActivity().finish();
                }
            }
            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                long costTime = responsedMessage.getCostTime();
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (!subPbHttpResponseMessage.hasError()) {
                        this.dpP.e(subPbHttpResponseMessage.pbFloorData);
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
                        this.dpP.e(subPbSocketResponseMessage.pbFloorData);
                        return;
                    }
                    return;
                }
            }
            arrayList = this.dpP.dpH;
            if (arrayList != null) {
                arrayList2 = this.dpP.dpH;
                if (arrayList2.size() > 0) {
                    try {
                        arrayList4 = this.dpP.dpH;
                        for (int size = arrayList4.size() - 1; size >= 0; size--) {
                            arrayList5 = this.dpP.dpH;
                            com.baidu.tieba.pb.data.g gVar5 = (com.baidu.tieba.pb.data.g) arrayList5.get(size);
                            z4 = this.dpP.dpJ;
                            if (z4) {
                                gVar4 = this.dpP.dpd;
                                gVar4.c(gVar5, true);
                            } else {
                                gVar3 = this.dpP.dpd;
                                gVar3.b(gVar5, true);
                            }
                        }
                    } catch (Exception e) {
                        BdLog.detailException(e);
                    }
                    arrayList3 = this.dpP.dpH;
                    arrayList3.clear();
                }
            }
            int error = responsedMessage.getError();
            String errorString2 = responsedMessage.getErrorString();
            bVar = this.dpP.bbO;
            if (bVar == null) {
                this.dpP.bbO = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
            }
            bVar2 = this.dpP.bbO;
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
                    bVar3 = this.dpP.bbO;
                    bVar3.a(z, true, error, errorString2, i, j3, j2);
                    this.dpP.bbO = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    this.dpP.bbO = null;
                }
                if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                    aVar = this.dpP.dpD;
                    if (aVar != null) {
                        aVar2 = this.dpP.dpD;
                        aVar2.a(false, error, errorString2, null);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        gVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        gVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                    }
                    if (gVar.avH().errorno.intValue() != 0) {
                        aVar5 = this.dpP.dpD;
                        if (aVar5 != null) {
                            aVar6 = this.dpP.dpD;
                            aVar6.a(false, gVar.ddf.errorno.intValue(), gVar.ddf.errmsg, null);
                            return;
                        }
                        return;
                    }
                    if (gVar.LC() != null && gVar.LC().getAuthor() != null) {
                        str5 = gVar.LC().getAuthor().getUserId();
                    }
                    z2 = this.dpP.dpJ;
                    if (!z2) {
                        for (int i2 = 0; i2 < gVar.avM().size(); i2++) {
                            boolean equals = str5.equals(gVar.avM().get(i2).getAuthor().getUserId());
                            tbPageContext = this.dpP.MX;
                            gVar.avM().get(i2).b(tbPageContext, equals);
                        }
                    }
                    if (gVar.avI() != null) {
                        this.dpP.postID = gVar.avI().getId();
                    }
                    if (gVar.LC() != null) {
                        this.dpP.threadID = gVar.LC().getId();
                        this.dpP.dde = gVar.pu();
                        this.dpP.dpC = gVar.LC().tv();
                    }
                    str = this.dpP.dpC;
                    if (str != null) {
                        str2 = this.dpP.postID;
                        if (str2 != null) {
                            str3 = this.dpP.dpC;
                            str4 = this.dpP.postID;
                            if (str3.equals(str4)) {
                                this.dpP.dde = true;
                            }
                        }
                    }
                    z3 = this.dpP.dpJ;
                    if (!z3) {
                        this.dpP.c(gVar);
                    } else {
                        this.dpP.d(gVar);
                    }
                    aVar3 = this.dpP.dpD;
                    if (aVar3 != null) {
                        boolean z5 = this.dpP.aAh();
                        aVar4 = this.dpP.dpD;
                        gVar2 = this.dpP.dpd;
                        aVar4.a(z5, error, errorString2, gVar2);
                    }
                }
            }
        }
    }
}
