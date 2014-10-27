package com.baidu.tieba.mention;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes.dex */
public class ReplyMeHttpResponseMessage extends TbHttpResponsedMessage {
    private boolean hasNetworkError;
    private com.baidu.tieba.model.am model;
    private int updateType;

    public int getUpdateType() {
        return this.updateType;
    }

    public com.baidu.tieba.model.am getModel() {
        return this.model;
    }

    public void setModel(com.baidu.tieba.model.am amVar) {
        this.model = amVar;
    }

    public boolean hasNetworkError() {
        return this.hasNetworkError;
    }

    public ReplyMeHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof ReplyMeRequestMessage) {
            ReplyMeRequestMessage replyMeRequestMessage = (ReplyMeRequestMessage) message.getExtra();
            this.model = replyMeRequestMessage.getModel();
            this.updateType = replyMeRequestMessage.getUpdateType();
            this.hasNetworkError = hasError();
        }
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        ReplyMeResIdl replyMeResIdl = (ReplyMeResIdl) new Wire(new Class[0]).parseFrom(bArr, ReplyMeResIdl.class);
        setError(replyMeResIdl.error.errorno.intValue());
        setErrorString(replyMeResIdl.error.usermsg);
        if (getError() == 0) {
            this.model.a(replyMeResIdl.data);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (this.updateType != 4) {
            com.baidu.tbadk.core.a.a.kS().C("tb_user_profile", TbadkApplication.getCurrentAccountName()).b("replyme_cache", bArr);
        }
    }
}
