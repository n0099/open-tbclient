package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes.dex */
public class AtMeNetModel extends NetModel<e, f, ad> {
    public AtMeNetModel(TbPageContext<ad> tbPageContext, e eVar) {
        super(tbPageContext, eVar, NetModel.NetModelType.TYPE_NETWORK);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Fa() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String Fc() {
        return "c/u/feed/atme";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<f> getResponseDataClass() {
        return f.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Fb() {
        return 0;
    }
}
