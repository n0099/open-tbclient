package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbFakeFloorModel eGx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbFakeFloorModel pbFakeFloorModel, int i, int i2) {
        super(i, i2);
        this.eGx = pbFakeFloorModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        PbFakeFloorModel.a aVar;
        PbFakeFloorModel.a aVar2;
        com.baidu.tieba.pb.data.n nVar;
        com.baidu.tieba.pb.data.n nVar2;
        com.baidu.tieba.pb.data.n nVar3;
        TbPageContext tbPageContext;
        com.baidu.tieba.pb.data.n nVar4;
        com.baidu.tieba.pb.data.n nVar5;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        boolean z = false;
        if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
            bdUniqueId = this.eGx.unique_id;
            if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
                this.eGx.eGt = false;
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        tbPageContext3 = this.eGx.ajP;
                        errorString = tbPageContext3.getPageActivity().getResources().getString(w.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    tbPageContext2 = this.eGx.ajP;
                    tbPageContext2.showToast(errorString);
                    return;
                }
                com.baidu.tieba.pb.data.n nVar6 = null;
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    nVar6 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                    nVar6 = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                }
                if (nVar6 != null && nVar6.aNh() != null) {
                    PostData postData = (PostData) z.c(nVar6.aNh(), nVar6.aNh().size() - 1);
                    if (postData != null) {
                        nVar = this.eGx.eGs;
                        if (nVar != null) {
                            nVar2 = this.eGx.eGs;
                            if (nVar2.aNd() != null) {
                                nVar3 = this.eGx.eGs;
                                if (nVar3.Mv() != null) {
                                    nVar4 = this.eGx.eGs;
                                    if (nVar4.Mv().getAuthor() != null && postData.getAuthor() != null) {
                                        nVar5 = this.eGx.eGs;
                                        String userId = nVar5.Mv().getAuthor().getUserId();
                                        if (userId != null && userId.equals(postData.getAuthor().getUserId())) {
                                            z = true;
                                        }
                                    }
                                }
                                tbPageContext = this.eGx.ajP;
                                postData.a(tbPageContext, z);
                            }
                        }
                    }
                    aVar = this.eGx.eGv;
                    if (aVar != null) {
                        aVar2 = this.eGx.eGv;
                        aVar2.l(postData);
                    }
                }
            }
        }
    }
}
