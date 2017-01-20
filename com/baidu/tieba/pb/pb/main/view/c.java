package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbFakeFloorModel eqO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PbFakeFloorModel pbFakeFloorModel, int i, int i2) {
        super(i, i2);
        this.eqO = pbFakeFloorModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        PbFakeFloorModel.a aVar;
        PbFakeFloorModel.a aVar2;
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
            bdUniqueId = this.eqO.unique_id;
            if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
                this.eqO.eqK = false;
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        tbPageContext3 = this.eqO.FY;
                        errorString = tbPageContext3.getPageActivity().getResources().getString(r.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    tbPageContext2 = this.eqO.FY;
                    tbPageContext2.showToast(errorString);
                    return;
                }
                com.baidu.tieba.pb.data.j jVar6 = null;
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    jVar6 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                    jVar6 = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                }
                if (jVar6 != null && jVar6.aKA() != null) {
                    p pVar = (p) w.c(jVar6.aKA(), jVar6.aKA().size() - 1);
                    if (pVar != null) {
                        jVar = this.eqO.eqJ;
                        if (jVar != null) {
                            jVar2 = this.eqO.eqJ;
                            if (jVar2.aKw() != null) {
                                jVar3 = this.eqO.eqJ;
                                if (jVar3.Ji() != null) {
                                    jVar4 = this.eqO.eqJ;
                                    if (jVar4.Ji().getAuthor() != null && pVar.getAuthor() != null) {
                                        jVar5 = this.eqO.eqJ;
                                        String userId = jVar5.Ji().getAuthor().getUserId();
                                        if (userId != null && userId.equals(pVar.getAuthor().getUserId())) {
                                            z = true;
                                        }
                                    }
                                }
                                tbPageContext = this.eqO.FY;
                                pVar.b(tbPageContext, z);
                            }
                        }
                    }
                    aVar = this.eqO.eqM;
                    if (aVar != null) {
                        aVar2 = this.eqO.eqM;
                        aVar2.h(pVar);
                    }
                }
            }
        }
    }
}
