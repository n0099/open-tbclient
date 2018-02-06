package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes2.dex */
public class ReplyMeHttpResponseMessage extends MvcProtobufHttpResponsedMessage<n, ReplyMeResIdl> {
    public ReplyMeHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    protected Class<ReplyMeResIdl> getProtobufResponseIdlClass() {
        return ReplyMeResIdl.class;
    }
}
