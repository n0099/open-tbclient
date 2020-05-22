package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetAutoModel;
/* loaded from: classes9.dex */
public class ReplyMeNetModel extends NetAutoModel<k, l, ReplyMessageFragment> {
    public ReplyMeNetModel(TbPageContext tbPageContext, k kVar) {
        super(tbPageContext, kVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> Mw() {
        return ReplyMeHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetAutoModel, com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> My() {
        return ReplyMeSocketResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Mt() {
        return 1002200;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected String Mm() {
        return Config.REPLYME_ADDRESS;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<l> getResponseDataClass() {
        return l.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int Ms() {
        return CmdConfigSocket.CMD_REPLY_ME;
    }
}
