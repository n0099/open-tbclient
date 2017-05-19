package com.baidu.tieba.personPolymeric.mode.message;

import UserPost.UserPostResIdl;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* loaded from: classes.dex */
public class UserPostPageHttpResponseMessage extends TbHttpResponsedMessage {
    private boolean isThread;
    private PersonPostModel personPostModel;

    public UserPostPageHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof UserPostPageRequestMessage) {
            this.isThread = ((UserPostPageRequestMessage) message.getExtra()).isThread();
        }
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.personPostModel = new PersonPostModel(null, null);
        UserPostResIdl parseProtobuf = this.personPostModel.parseProtobuf(bArr);
        setError(parseProtobuf.error.errorno.intValue());
        setErrorString(parseProtobuf.error.usermsg);
        this.personPostModel.setErrorCode(parseProtobuf.error.errorno.intValue());
        this.personPostModel.setErrorString(parseProtobuf.error.usermsg);
    }

    public PersonPostModel getPersonPostModel() {
        return this.personPostModel;
    }
}
