package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import d.b.i0.f1.b.m;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes4.dex */
public class ReplyMeSocketResponseMessage extends MvcSocketResponsedMessage<m, ReplyMeResIdl> {
    public ReplyMeSocketResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public Class<ReplyMeResIdl> getProtobufResponseIdlClass() {
        return ReplyMeResIdl.class;
    }
}
