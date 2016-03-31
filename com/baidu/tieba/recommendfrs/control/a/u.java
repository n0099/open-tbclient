package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendFrsHttpResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendFrsSocketResponsedMessage;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.mvc.model.d<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n, BaseFragmentActivity> {
    public u(TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tbadk.mvc.b.h hVar) {
        super(tbPageContext, hVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.n, ?>> oP() {
        return RecommendFrsHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.n, ?>> oO() {
        return RecommendFrsSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oL() {
        return CmdConfigHttp.CMD_RECOMMEND_FRS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String oM() {
        return TbConfig.RECOMMEND_FRS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<com.baidu.tieba.recommendfrs.data.n> getResponseDataClass() {
        return com.baidu.tieba.recommendfrs.data.n.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oN() {
        return 309092;
    }
}
