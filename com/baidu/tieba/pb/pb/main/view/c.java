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
    final /* synthetic */ PbFakeFloorModel erY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PbFakeFloorModel pbFakeFloorModel, int i, int i2) {
        super(i, i2);
        this.erY = pbFakeFloorModel;
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
            bdUniqueId = this.erY.unique_id;
            if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
                this.erY.erU = false;
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        tbPageContext3 = this.erY.ajT;
                        errorString = tbPageContext3.getPageActivity().getResources().getString(w.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    tbPageContext2 = this.erY.ajT;
                    tbPageContext2.showToast(errorString);
                    return;
                }
                com.baidu.tieba.pb.data.j jVar6 = null;
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    jVar6 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                    jVar6 = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                }
                if (jVar6 != null && jVar6.aJZ() != null) {
                    PostData postData = (PostData) x.c(jVar6.aJZ(), jVar6.aJZ().size() - 1);
                    if (postData != null) {
                        jVar = this.erY.erT;
                        if (jVar != null) {
                            jVar2 = this.erY.erT;
                            if (jVar2.aJV() != null) {
                                jVar3 = this.erY.erT;
                                if (jVar3.Kn() != null) {
                                    jVar4 = this.erY.erT;
                                    if (jVar4.Kn().getAuthor() != null && postData.getAuthor() != null) {
                                        jVar5 = this.erY.erT;
                                        String userId = jVar5.Kn().getAuthor().getUserId();
                                        if (userId != null && userId.equals(postData.getAuthor().getUserId())) {
                                            z = true;
                                        }
                                    }
                                }
                                tbPageContext = this.erY.ajT;
                                postData.b(tbPageContext, z);
                            }
                        }
                    }
                    aVar = this.erY.erW;
                    if (aVar != null) {
                        aVar2 = this.erY.erW;
                        aVar2.i(postData);
                    }
                }
            }
        }
    }
}
