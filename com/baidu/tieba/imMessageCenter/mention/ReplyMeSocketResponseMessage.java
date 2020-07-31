package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes16.dex */
public class ReplyMeSocketResponseMessage extends MvcSocketResponsedMessage<l, ReplyMeResIdl> {
    public ReplyMeSocketResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    protected Class<ReplyMeResIdl> getProtobufResponseIdlClass() {
        return ReplyMeResIdl.class;
    }
}
