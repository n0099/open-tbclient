package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
/* loaded from: classes.dex */
public class au extends com.baidu.tbadk.mvc.model.d<av, aw, bd> {
    public au(TbPageContext<bd> tbPageContext, av avVar) {
        super(tbPageContext, avVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> oW() {
        return ReplyMeHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> oV() {
        return ReplyMeSocketResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oS() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String oT() {
        return "c/u/feed/replyme";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<aw> getResponseDataClass() {
        return aw.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oU() {
        return 303007;
    }
}
