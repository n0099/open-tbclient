package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes2.dex */
public class ReplyMeNetModel extends NetAutoModel<at, au, ReplyMessageActivity> {
    public ReplyMeNetModel(TbPageContext<ReplyMessageActivity> tbPageContext, at atVar) {
        super(tbPageContext, atVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> EC() {
        return ReplyMeHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> EE() {
        return ReplyMeSocketResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Ew() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String Ey() {
        return "c/u/feed/replyme";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<au> getResponseDataClass() {
        return au.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Ex() {
        return 303007;
    }
}
