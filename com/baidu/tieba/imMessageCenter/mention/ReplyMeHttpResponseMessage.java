package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import d.a.n0.g1.b.m;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes4.dex */
public class ReplyMeHttpResponseMessage extends MvcProtobufHttpResponsedMessage<m, ReplyMeResIdl> {
    public ReplyMeHttpResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
    public Class<ReplyMeResIdl> getProtobufResponseIdlClass() {
        return ReplyMeResIdl.class;
    }
}
