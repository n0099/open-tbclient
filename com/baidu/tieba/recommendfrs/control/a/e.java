package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendFrsHttpResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendFrsSocketResponsedMessage;
import tbclient.ExcFrsPage.ExcFrsPageResIdl;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.model.d<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c, BaseFragmentActivity> {
    public e(TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.recommendfrs.data.d dVar) {
        super(tbPageContext, dVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.c, ExcFrsPageResIdl>> pd() {
        return RecommendFrsHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.c, ExcFrsPageResIdl>> pc() {
        return RecommendFrsSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oZ() {
        return CmdConfigHttp.CMD_RECOMMEND_FRS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String pa() {
        return TbConfig.RECOMMEND_FRS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<com.baidu.tieba.recommendfrs.data.c> getResponseDataClass() {
        return com.baidu.tieba.recommendfrs.data.c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int pb() {
        return 309092;
    }
}
