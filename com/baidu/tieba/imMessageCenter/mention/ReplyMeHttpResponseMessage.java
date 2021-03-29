package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import d.b.i0.e1.b.m;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes3.dex */
public class ReplyMeHttpResponseMessage extends MvcProtobufHttpResponsedMessage<m, ReplyMeResIdl> {
    public ReplyMeHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public Class<ReplyMeResIdl> getProtobufResponseIdlClass() {
        return ReplyMeResIdl.class;
    }
}
