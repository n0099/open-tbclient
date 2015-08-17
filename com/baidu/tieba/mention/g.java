package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes.dex */
public class g extends NetModel<h, i, SingleMentionActivity> {
    public g(TbPageContext<SingleMentionActivity> tbPageContext, h hVar) {
        super(tbPageContext, hVar, NetModel.NetModelType.TYPE_NETWORK);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oU() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String oV() {
        return "c/u/feed/atme";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<i> getResponseDataClass() {
        return i.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oW() {
        return 0;
    }
}
