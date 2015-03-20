package com.baidu.tieba.mention;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
/* loaded from: classes.dex */
public class af extends com.baidu.tbadk.mvc.model.e<ag, ah, SingleMentionActivity> {
    public af(TbPageContext<SingleMentionActivity> tbPageContext, ag agVar) {
        super(tbPageContext, agVar);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcProtobufHttpResponsedMessage> oB() {
        return ReplyMeHttpResponseMessage.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected Class<? extends MvcSocketResponsedMessage> oA() {
        return ReplyMeSocketResponseMessage.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public int ox() {
        return CmdConfigHttp.REPLYME_HTTP_CMD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public String oy() {
        return "c/u/feed/replyme";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.mvc.model.NetModel
    public Class<ah> getResponseDataClass() {
        return ah.class;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel
    protected int oz() {
        return 303007;
    }
}
