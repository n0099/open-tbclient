package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.model.NetModel;
import d.b.j0.f1.b.b;
import d.b.j0.f1.b.c;
/* loaded from: classes4.dex */
public class AtMeNetModel extends NetModel<b, c, AtMessageActivity> {
    public AtMeNetModel(TbPageContext<AtMessageActivity> tbPageContext, b bVar) {
        super(tbPageContext, bVar, NetModel.NetModelType.TYPE_NETWORK);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int F() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String I() {
        return "c/u/feed/atme";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int J() {
        return 0;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<c> getResponseDataClass() {
        return c.class;
    }
}
