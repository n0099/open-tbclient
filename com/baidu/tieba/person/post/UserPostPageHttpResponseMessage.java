package com.baidu.tieba.person.post;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import tbclient.UserPost.UserPostResIdl;
/* loaded from: classes.dex */
public class UserPostPageHttpResponseMessage extends TbHttpResponsedMessage {
    private boolean isThread;
    private PersonPostModel personPostModel;

    public UserPostPageHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        this.isThread = ((UserPostPageRequestMessage) getOrginalMessage().getExtra()).isThread();
        this.personPostModel = new PersonPostModel();
        UserPostResIdl parseProtobuf = this.personPostModel.parseProtobuf(bArr);
        setError(parseProtobuf.error.errorno.intValue());
        setErrorString(parseProtobuf.error.usermsg);
        this.personPostModel.setErrorCode(parseProtobuf.error.errorno.intValue());
        this.personPostModel.setErrorString(parseProtobuf.error.usermsg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void processInBackGround(int i, byte[] bArr) {
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
