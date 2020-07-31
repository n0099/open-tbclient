package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes16.dex */
public class AtMeNetModel extends NetModel<b, c, AtMessageActivity> {
    public AtMeNetModel(TbPageContext<AtMessageActivity> tbPageContext, b bVar) {
        super(tbPageContext, bVar, NetModel.NetModelType.TYPE_NETWORK);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int NH() {
        return 1002200;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String NA() {
        return Config.ATME_ADDRESS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<c> getResponseDataClass() {
        return c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int NG() {
        return 0;
    }
}
