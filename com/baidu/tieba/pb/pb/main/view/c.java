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
    final /* synthetic */ PbFakeFloorModel euq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(PbFakeFloorModel pbFakeFloorModel, int i, int i2) {
        super(i, i2);
        this.euq = pbFakeFloorModel;
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
            bdUniqueId = this.euq.unique_id;
            if (bdUniqueId == responsedMessage.getOrginalMessage().getTag()) {
                this.euq.eum = false;
                if (responsedMessage.hasError()) {
                    if (StringUtils.isNull(responsedMessage.getErrorString())) {
                        tbPageContext3 = this.euq.ajU;
                        errorString = tbPageContext3.getPageActivity().getResources().getString(w.l.neterror);
                    } else {
                        errorString = responsedMessage.getErrorString();
                    }
                    tbPageContext2 = this.euq.ajU;
                    tbPageContext2.showToast(errorString);
                    return;
                }
                com.baidu.tieba.pb.data.j jVar6 = null;
                if (responsedMessage instanceof SubPbHttpResponseMessage) {
                    jVar6 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                    jVar6 = ((SubPbSocketResponseMessage) responsedMessage).pbFloorData;
                }
                if (jVar6 != null && jVar6.aLa() != null) {
                    PostData postData = (PostData) x.c(jVar6.aLa(), jVar6.aLa().size() - 1);
                    if (postData != null) {
                        jVar = this.euq.eul;
                        if (jVar != null) {
                            jVar2 = this.euq.eul;
                            if (jVar2.aKW() != null) {
                                jVar3 = this.euq.eul;
                                if (jVar3.Kn() != null) {
                                    jVar4 = this.euq.eul;
                                    if (jVar4.Kn().getAuthor() != null && postData.getAuthor() != null) {
                                        jVar5 = this.euq.eul;
                                        String userId = jVar5.Kn().getAuthor().getUserId();
                                        if (userId != null && userId.equals(postData.getAuthor().getUserId())) {
                                            z = true;
                                        }
                                    }
                                }
                                tbPageContext = this.euq.ajU;
                                postData.b(tbPageContext, z);
                            }
                        }
                    }
                    aVar = this.euq.euo;
                    if (aVar != null) {
                        aVar2 = this.euq.euo;
                        aVar2.i(postData);
                    }
                }
            }
        }
    }
}
