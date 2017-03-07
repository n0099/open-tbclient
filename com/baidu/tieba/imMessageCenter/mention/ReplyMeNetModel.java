package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes.dex */
public class ReplyMeNetModel extends NetAutoModel<as, at, ReplyMessageActivity> {
    public ReplyMeNetModel(TbPageContext<ReplyMessageActivity> tbPageContext, as asVar) {
        super(tbPageContext, asVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> Fg() {
        return ReplyMeHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> Fi() {
        return ReplyMeSocketResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Fa() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String Fc() {
        return "c/u/feed/replyme";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<at> getResponseDataClass() {
        return at.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Fb() {
        return 303007;
    }
}
