package com.baidu.tieba.recommendfrs.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendFrsHttpResponsedMessage;
import com.baidu.tieba.recommendfrs.data.RecommendFrsSocketResponsedMessage;
/* loaded from: classes.dex */
public class f extends com.baidu.tbadk.mvc.model.e<com.baidu.tieba.recommendfrs.data.d, com.baidu.tieba.recommendfrs.data.c, BaseFragmentActivity> {
    public f(TbPageContext<BaseFragmentActivity> tbPageContext, com.baidu.tieba.recommendfrs.data.d dVar) {
        super(tbPageContext, dVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> oB() {
        return RecommendFrsHttpResponsedMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> oA() {
        return RecommendFrsSocketResponsedMessage.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int ox() {
        return CmdConfigHttp.CMD_RECOMMEND_FRS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String oy() {
        return "c/f/choiceness/finefrspage";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<com.baidu.tieba.recommendfrs.data.c> getResponseDataClass() {
        return com.baidu.tieba.recommendfrs.data.c.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oz() {
        return 307001;
    }
}
