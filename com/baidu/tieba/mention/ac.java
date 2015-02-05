package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
/* loaded from: classes.dex */
public class ac extends com.baidu.tbadk.mvc.model.e<ad, ae, SingleMentionActivity> {
    public ac(TbPageContext<SingleMentionActivity> tbPageContext, ad adVar) {
        super(tbPageContext, adVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> kI() {
        return ReplyMeHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> kH() {
        return ReplyMeSocketResponseMessage.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int kE() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String kF() {
        return "c/u/feed/replyme";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<ae> getResponseDataClass() {
        return ae.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int kG() {
        return 303007;
    }
}
