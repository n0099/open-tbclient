package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbFakeFloorModel epT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PbFakeFloorModel pbFakeFloorModel, int i, int i2) {
        super(i, i2);
        this.epT = pbFakeFloorModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        BdUniqueId bdUniqueId;
        PbFakeFloorModel.a aVar;
        PbFakeFloorModel.a aVar2;
        l lVar;
        l lVar2;
        l lVar3;
        TbPageContext tbPageContext;
        l lVar4;
        l lVar5;
        String errorString;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        boolean z = false;
        if (responsedMessage != null && responsedMessage.getOrginalMessage() != null) {
            bdUniqueId = this.epT.unique_id;
            if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
                this.epT.epP = false;
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        tbPageContext3 = this.epT.ajr;
                        errorString = tbPageContext3.getPageActivity().getResources().getString(w.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    tbPageContext2 = this.epT.ajr;
                    tbPageContext2.showToast(errorString);
                    return;
                }
                l lVar6 = null;
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    lVar6 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                    lVar6 = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                }
                if (lVar6 != null && lVar6.aIv() != null) {
                    PostData postData = (PostData) x.c(lVar6.aIv(), lVar6.aIv().size() - 1);
                    if (postData != null) {
                        lVar = this.epT.epO;
                        if (lVar != null) {
                            lVar2 = this.epT.epO;
                            if (lVar2.aIr() != null) {
                                lVar3 = this.epT.epO;
                                if (lVar3.JB() != null) {
                                    lVar4 = this.epT.epO;
                                    if (lVar4.JB().getAuthor() != null && postData.getAuthor() != null) {
                                        lVar5 = this.epT.epO;
                                        String userId = lVar5.JB().getAuthor().getUserId();
                                        if (userId != null && userId.equals(postData.getAuthor().getUserId())) {
                                            z = true;
                                        }
                                    }
                                }
                                tbPageContext = this.epT.ajr;
                                postData.a(tbPageContext, z);
                            }
                        }
                    }
                    aVar = this.epT.epR;
                    if (aVar != null) {
                        aVar2 = this.epT.epR;
                        aVar2.j(postData);
                    }
                }
            }
        }
    }
}
