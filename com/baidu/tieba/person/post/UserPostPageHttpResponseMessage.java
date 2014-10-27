package com.baidu.tieba.person.post;

import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import tbclient.UserPost.UserPostResIdl;
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
    public void decodeInBackGround(int i, byte[] bArr) {
        this.personPostModel = new PersonPostModel(null);
        UserPostResIdl parseProtobuf = this.personPostModel.parseProtobuf(bArr);
        setError(parseProtobuf.error.errorno.intValue());
        setErrorString(parseProtobuf.error.usermsg);
        this.personPostModel.setErrorCode(parseProtobuf.error.errorno.intValue());
        this.personPostModel.setErrorString(parseProtobuf.error.usermsg);
    }

    public PersonPostModel getPersonPostModel() {
        return this.personPostModel;
    }

    public void setPersonPostModel(PersonPostModel personPostModel) {
        this.personPostModel = personPostModel;
    }

    public boolean isThread() {
        return this.isThread;
    }

    public void setThread(boolean z) {
        this.isThread = z;
    }
}
