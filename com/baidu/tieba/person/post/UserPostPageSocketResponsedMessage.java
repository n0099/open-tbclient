package com.baidu.tieba.person.post;

import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import tbclient.UserPost.UserPostResIdl;
/* loaded from: classes.dex */
public class UserPostPageSocketResponsedMessage extends SocketResponsedMessage {
    private boolean isThread;
    private PersonPostModel personPostModel;

    public UserPostPageSocketResponsedMessage() {
        super(MessageTypes.CMD_USER_POST_PAGE);
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof UserPostPageRequestMessage) {
            this.isThread = ((UserPostPageRequestMessage) message.getExtra()).isThread();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
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
