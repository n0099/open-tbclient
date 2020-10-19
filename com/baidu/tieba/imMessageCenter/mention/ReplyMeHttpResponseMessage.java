package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes22.dex */
public class ReplyMeHttpResponseMessage extends MvcProtobufHttpResponsedMessage<l, ReplyMeResIdl> {
    public ReplyMeHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<ReplyMeResIdl> getProtobufResponseIdlClass() {
        return ReplyMeResIdl.class;
    }
}
