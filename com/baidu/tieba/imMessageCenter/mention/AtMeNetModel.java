package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes9.dex */
public class AtMeNetModel extends NetModel<b, c, AtMessageActivity> {
    public AtMeNetModel(TbPageContext<AtMessageActivity> tbPageContext, b bVar) {
        super(tbPageContext, bVar, NetModel.NetModelType.TYPE_NETWORK);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Mt() {
        return 1002200;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String Mm() {
        return Config.ATME_ADDRESS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<c> getResponseDataClass() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Ms() {
        return 0;
    }
}
