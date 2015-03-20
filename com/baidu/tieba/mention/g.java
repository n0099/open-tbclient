package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes.dex */
public class g extends NetModel<h, i, SingleMentionActivity> {
    public g(TbPageContext<SingleMentionActivity> tbPageContext, h hVar) {
        super(tbPageContext, hVar, NetModel.NetModelType.TYPE_NETWORK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int ox() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String oy() {
        return "c/u/feed/atme";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<i> getResponseDataClass() {
        return i.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oz() {
        return 0;
    }
}
