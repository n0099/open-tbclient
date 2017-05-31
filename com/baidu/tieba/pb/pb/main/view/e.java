package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbFakeFloorModel exb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbFakeFloorModel pbFakeFloorModel, int i, int i2) {
        super(i, i2);
        this.exb = pbFakeFloorModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        PbFakeFloorModel.a aVar;
        PbFakeFloorModel.a aVar2;
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
            bdUniqueId = this.exb.unique_id;
            if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
                this.exb.ewX = false;
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        tbPageContext3 = this.exb.ajh;
                        errorString = tbPageContext3.getPageActivity().getResources().getString(w.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    tbPageContext2 = this.exb.ajh;
                    tbPageContext2.showToast(errorString);
                    return;
                }
                n nVar6 = null;
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    nVar6 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                    nVar6 = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                }
                if (nVar6 != null && nVar6.aJn() != null) {
                    PostData postData = (PostData) x.c(nVar6.aJn(), nVar6.aJn().size() - 1);
                    if (postData != null) {
                        nVar = this.exb.ewW;
                        if (nVar != null) {
                            nVar2 = this.exb.ewW;
                            if (nVar2.aJj() != null) {
                                nVar3 = this.exb.ewW;
                                if (nVar3.LH() != null) {
                                    nVar4 = this.exb.ewW;
                                    if (nVar4.LH().getAuthor() != null && postData.getAuthor() != null) {
                                        nVar5 = this.exb.ewW;
                                        String userId = nVar5.LH().getAuthor().getUserId();
                                        if (userId != null && userId.equals(postData.getAuthor().getUserId())) {
                                            z = true;
                                        }
                                    }
                                }
                                tbPageContext = this.exb.ajh;
                                postData.a(tbPageContext, z);
                            }
                        }
                    }
                    aVar = this.exb.ewZ;
                    if (aVar != null) {
                        aVar2 = this.exb.ewZ;
                        aVar2.j(postData);
                    }
                }
            }
        }
    }
}
