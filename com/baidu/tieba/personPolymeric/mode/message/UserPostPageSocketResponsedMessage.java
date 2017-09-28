package com.baidu.tieba.personPolymeric.mode.message;

import UserPost.UserPostResIdl;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
/* loaded from: classes.dex */
public class UserPostPageSocketResponsedMessage extends SocketResponsedMessage {
    private boolean isHost;
    private boolean isThread;
    private int page;
    private PersonPostModel personPostModel;

    public UserPostPageSocketResponsedMessage() {
        super(303002);
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof UserPostPageRequestMessage) {
            UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) message.getExtra();
            this.isThread = userPostPageRequestMessage.isThread();
            this.isHost = userPostPageRequestMessage.isHost();
            this.page = userPostPageRequestMessage.getPn();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.personPostModel = new PersonPostModel(null, null, this.isHost);
        UserPostResIdl parseProtobuf = this.personPostModel.parseProtobuf(bArr, this.page);
        setError(parseProtobuf.error.errorno.intValue());
        setErrorString(parseProtobuf.error.usermsg);
        this.personPostModel.setErrorCode(parseProtobuf.error.errorno.intValue());
        this.personPostModel.setErrorString(parseProtobuf.error.usermsg);
    }

    public PersonPostModel getPersonPostModel() {
        return this.personPostModel;
    }
}
