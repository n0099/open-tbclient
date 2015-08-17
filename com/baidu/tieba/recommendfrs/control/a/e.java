package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendFrsHttpResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendFrsSocketResponsedMessage;
import com.baidu.tieba.recommendfrs.data.g;
import com.baidu.tieba.recommendfrs.data.h;
import tbclient.FineFrsPage.FineFrsPageResIdl;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.mvc.model.d<h, g, BaseFragmentActivity> {
    public e(TbPageContext<BaseFragmentActivity> tbPageContext, h hVar) {
        super(tbPageContext, hVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage<g, FineFrsPageResIdl>> oY() {
        return RecommendFrsHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage<g, FineFrsPageResIdl>> oX() {
        return RecommendFrsSocketResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oU() {
        return CmdConfigHttp.CMD_RECOMMEND_FRS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String oV() {
        return "c/f/choiceness/finefrspage";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<g> getResponseDataClass() {
        return g.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oW() {
        return 307001;
    }
}
