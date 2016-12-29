package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.pb.pb.main.view.c;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ c ehF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar, int i, int i2) {
        super(i, i2);
        this.ehF = cVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        c.a aVar;
        c.a aVar2;
        com.baidu.tieba.pb.data.j jVar;
        com.baidu.tieba.pb.data.j jVar2;
        com.baidu.tieba.pb.data.j jVar3;
        TbPageContext tbPageContext;
        com.baidu.tieba.pb.data.j jVar4;
        com.baidu.tieba.pb.data.j jVar5;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        boolean z = false;
        if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
            bdUniqueId = this.ehF.unique_id;
            if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
                this.ehF.ehC = false;
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        tbPageContext3 = this.ehF.GO;
                        errorString = tbPageContext3.getPageActivity().getResources().getString(r.j.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    tbPageContext2 = this.ehF.GO;
                    tbPageContext2.showToast(errorString);
                    return;
                }
                com.baidu.tieba.pb.data.j jVar6 = null;
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    jVar6 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                    jVar6 = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                }
                if (jVar6 != null && jVar6.aIJ() != null) {
                    q qVar = (q) x.c(jVar6.aIJ(), jVar6.aIJ().size() - 1);
                    if (qVar != null) {
                        jVar = this.ehF.ehB;
                        if (jVar != null) {
                            jVar2 = this.ehF.ehB;
                            if (jVar2.aIF() != null) {
                                jVar3 = this.ehF.ehB;
                                if (jVar3.IU() != null) {
                                    jVar4 = this.ehF.ehB;
                                    if (jVar4.IU().getAuthor() != null && qVar.getAuthor() != null) {
                                        jVar5 = this.ehF.ehB;
                                        String userId = jVar5.IU().getAuthor().getUserId();
                                        if (userId != null && userId.equals(qVar.getAuthor().getUserId())) {
                                            z = true;
                                        }
                                    }
                                }
                                tbPageContext = this.ehF.GO;
                                qVar.b(tbPageContext, z);
                            }
                        }
                    }
                    aVar = this.ehF.ehE;
                    if (aVar != null) {
                        aVar2 = this.ehF.ehE;
                        aVar2.i(qVar);
                    }
                }
            }
        }
    }
}
