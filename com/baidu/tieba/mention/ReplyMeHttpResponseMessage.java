package com.baidu.tieba.mention;

import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes.dex */
public class ReplyMeHttpResponseMessage extends MvcProtobufHttpResponsedMessage<ak, ReplyMeResIdl> {
    public ReplyMeHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<ReplyMeResIdl> getProtobufResponseIdlClass() {
        return ReplyMeResIdl.class;
    }
}
