package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendGodHttpResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendGodSocketResponsedMessage;
/* loaded from: classes.dex */
public class w extends com.baidu.tbadk.mvc.model.d<com.baidu.tbadk.mvc.b.h, com.baidu.tieba.recommendfrs.data.n, BaseFragmentActivity> {
    public w(TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tbadk.mvc.b.h hVar) {
        super(tbPageContext, hVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage<com.baidu.tieba.recommendfrs.data.n, ?>> oP() {
        return RecommendGodHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage<com.baidu.tieba.recommendfrs.data.n, ?>> oO() {
        return RecommendGodSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oL() {
        return CmdConfigHttp.CMD_RECOMMEND_FRS_GOD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String oM() {
        return TbConfig.RECOMMEND_FRS_GOD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class getResponseDataClass() {
        return com.baidu.tieba.recommendfrs.data.r.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oN() {
        return 309281;
    }
}
