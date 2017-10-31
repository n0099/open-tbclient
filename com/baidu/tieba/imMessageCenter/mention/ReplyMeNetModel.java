package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes2.dex */
public class ReplyMeNetModel extends NetAutoModel<l, m, ReplyMessageActivity> {
    public ReplyMeNetModel(TbPageContext<ReplyMessageActivity> tbPageContext, l lVar) {
        super(tbPageContext, lVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> Fh() {
        return ReplyMeHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> Fj() {
        return ReplyMeSocketResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Fb() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String Fd() {
        return "c/u/feed/replyme";
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<m> getResponseDataClass() {
        return m.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Fc() {
        return 303007;
    }
}
