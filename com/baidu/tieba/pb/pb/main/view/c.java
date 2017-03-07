package com.baidu.tieba.pb.pb.main.view;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbHttpResponseMessage;
import com.baidu.tieba.pb.pb.sub.SubPbSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ PbFakeFloorModel etV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PbFakeFloorModel pbFakeFloorModel, int i, int i2) {
        super(i, i2);
        this.etV = pbFakeFloorModel;
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
            bdUniqueId = this.etV.unique_id;
            if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
                this.etV.etR = false;
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        tbPageContext3 = this.etV.ajF;
                        errorString = tbPageContext3.getPageActivity().getResources().getString(w.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    tbPageContext2 = this.etV.ajF;
                    tbPageContext2.showToast(errorString);
                    return;
                }
                com.baidu.tieba.pb.data.j jVar6 = null;
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    jVar6 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                    jVar6 = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                }
                if (jVar6 != null && jVar6.aJS() != null) {
                    PostData postData = (PostData) x.c(jVar6.aJS(), jVar6.aJS().size() - 1);
                    if (postData != null) {
                        jVar = this.etV.etQ;
                        if (jVar != null) {
                            jVar2 = this.etV.etQ;
                            if (jVar2.aJO() != null) {
                                jVar3 = this.etV.etQ;
                                if (jVar3.JN() != null) {
                                    jVar4 = this.etV.etQ;
                                    if (jVar4.JN().getAuthor() != null && postData.getAuthor() != null) {
                                        jVar5 = this.etV.etQ;
                                        String userId = jVar5.JN().getAuthor().getUserId();
                                        if (userId != null && userId.equals(postData.getAuthor().getUserId())) {
                                            z = true;
                                        }
                                    }
                                }
                                tbPageContext = this.etV.ajF;
                                postData.b(tbPageContext, z);
                            }
                        }
                    }
                    aVar = this.etV.etT;
                    if (aVar != null) {
                        aVar2 = this.etV.etT;
                        aVar2.i(postData);
                    }
                }
            }
        }
    }
}
