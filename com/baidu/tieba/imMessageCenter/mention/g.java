package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes.dex */
public class g extends NetModel<h, i, bf> {
    public g(TbPageContext<bf> tbPageContext, h hVar) {
        super(tbPageContext, hVar, NetModel.NetModelType.TYPE_NETWORK);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int kY() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String kZ() {
        return "c/u/feed/atme";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<i> getResponseDataClass() {
        return i.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int la() {
        return 0;
    }
}
