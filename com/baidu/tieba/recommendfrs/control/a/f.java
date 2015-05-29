package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendFrsHttpResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendFrsSocketResponsedMessage;
import com.baidu.tieba.recommendfrs.data.g;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.model.e<g, com.baidu.tieba.recommendfrs.data.f, BaseFragmentActivity> {
    public f(TbPageContext<BaseFragmentActivity> tbPageContext, g gVar) {
        super(tbPageContext, gVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> oR() {
        return RecommendFrsHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> oQ() {
        return RecommendFrsSocketResponsedMessage.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int oN() {
        return CmdConfigHttp.CMD_RECOMMEND_FRS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String oO() {
        return "c/f/choiceness/finefrspage";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<com.baidu.tieba.recommendfrs.data.f> getResponseDataClass() {
        return com.baidu.tieba.recommendfrs.data.f.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oP() {
        return 307001;
    }
}
