package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes.dex */
public class g extends NetModel<h, i, be> {
    public g(TbPageContext<be> tbPageContext, h hVar) {
        super(tbPageContext, hVar, NetModel.NetModelType.TYPE_NETWORK);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oL() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String oM() {
        return "c/u/feed/atme";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<i> getResponseDataClass() {
        return i.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oN() {
        return 0;
    }
}
