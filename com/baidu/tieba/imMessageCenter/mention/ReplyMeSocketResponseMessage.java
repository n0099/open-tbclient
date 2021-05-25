package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import d.a.n0.g1.b.m;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes4.dex */
public class ReplyMeSocketResponseMessage extends MvcSocketResponsedMessage<m, ReplyMeResIdl> {
    public ReplyMeSocketResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public Class<ReplyMeResIdl> getProtobufResponseIdlClass() {
        return ReplyMeResIdl.class;
    }
}
