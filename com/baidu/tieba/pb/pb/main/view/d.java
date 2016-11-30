package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.view.c;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ c eDE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i, int i2) {
        super(i, i2);
        this.eDE = cVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        c.a aVar;
        c.a aVar2;
        n nVar;
        n nVar2;
        n nVar3;
        TbPageContext tbPageContext;
        n nVar4;
        n nVar5;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        boolean z = false;
        if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
            bdUniqueId = this.eDE.unique_id;
            if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
                this.eDE.eDB = false;
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        tbPageContext3 = this.eDE.GO;
                        errorString = tbPageContext3.getPageActivity().getResources().getString(r.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    tbPageContext2 = this.eDE.GO;
                    tbPageContext2.showToast(errorString);
                    return;
                }
                n nVar6 = null;
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    nVar6 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                    nVar6 = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                }
                if (nVar6 != null && nVar6.aOK() != null) {
                    q qVar = (q) x.c(nVar6.aOK(), nVar6.aOK().size() - 1);
                    if (qVar != null) {
                        nVar = this.eDE.eDA;
                        if (nVar != null) {
                            nVar2 = this.eDE.eDA;
                            if (nVar2.aOG() != null) {
                                nVar3 = this.eDE.eDA;
                                if (nVar3.Jz() != null) {
                                    nVar4 = this.eDE.eDA;
                                    if (nVar4.Jz().getAuthor() != null && qVar.getAuthor() != null) {
                                        nVar5 = this.eDE.eDA;
                                        String userId = nVar5.Jz().getAuthor().getUserId();
                                        if (userId != null && userId.equals(qVar.getAuthor().getUserId())) {
                                            z = true;
                                        }
                                    }
                                }
                                tbPageContext = this.eDE.GO;
                                qVar.b(tbPageContext, z);
                            }
                        }
                    }
                    aVar = this.eDE.eDD;
                    if (aVar != null) {
                        aVar2 = this.eDE.eDD;
                        aVar2.i(qVar);
                    }
                }
            }
        }
    }
}
