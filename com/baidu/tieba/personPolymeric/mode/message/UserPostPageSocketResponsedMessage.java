package com.baidu.tieba.personPolymeric.mode.message;

import UserPost.UserPostResIdl;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import tbclient.User;
/* loaded from: classes5.dex */
public class UserPostPageSocketResponsedMessage extends SocketResponsedMessage {
    public int from;
    public boolean isHost;
    public int page;
    public PersonPostModel personPostModel;
    public User threadUser;

    public UserPostPageSocketResponsedMessage() {
        super(303002);
    }

    public PersonPostModel getPersonPostModel() {
        return this.personPostModel;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void setOrginalMessage(Message<?> message) {
        super.setOrginalMessage(message);
        if (message.getExtra() instanceof UserPostPageRequestMessage) {
            UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) message.getExtra();
            this.isHost = userPostPageRequestMessage.isHost();
            this.page = userPostPageRequestMessage.getPn();
            this.from = userPostPageRequestMessage.getFrom();
            this.threadUser = userPostPageRequestMessage.getThreadUser();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PersonPostModel personPostModel = new PersonPostModel(null, null, this.isHost, this.from);
        this.personPostModel = personPostModel;
        UserPostResIdl parseProtobuf = personPostModel.parseProtobuf(bArr, this.page, this.threadUser);
        setError(parseProtobuf.error.errorno.intValue());
        setErrorString(parseProtobuf.error.usermsg);
        this.personPostModel.setErrorCode(parseProtobuf.error.errorno.intValue());
        this.personPostModel.setErrorString(parseProtobuf.error.usermsg);
    }
}
