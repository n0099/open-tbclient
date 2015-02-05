package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.model.NetModel;
/* loaded from: classes.dex */
public class d extends NetModel<f, g, PraiseListActivity> {
    public d(TbPageContext<PraiseListActivity> tbPageContext, f fVar) {
        super(tbPageContext, fVar, NetModel.NetModelType.TYPE_HTTP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<g> getResponseDataClass() {
        return g.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int kE() {
        return CmdConfigHttp.PRAISE_LIST_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int kG() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String kF() {
        return "c/u/zan/getuserlist";
    }
}
