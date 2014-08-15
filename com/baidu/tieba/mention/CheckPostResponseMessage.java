package com.baidu.tieba.mention;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CheckPost.CheckPostResIdl;
/* loaded from: classes.dex */
public class CheckPostResponseMessage extends SocketResponsedMessage {
    private long forumId;
    private long postState;

    public CheckPostResponseMessage() {
        super(303010);
    }

    public long getPostState() {
        return this.postState;
    }

    public void setPostState(long j) {
        this.postState = j;
    }

    public long getForumId() {
        return this.forumId;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        CheckPostResIdl checkPostResIdl = (CheckPostResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckPostResIdl.class);
        setError(checkPostResIdl.error.errorno.intValue());
        setErrorString(checkPostResIdl.error.usermsg);
        if (getError() == 0) {
            this.postState = checkPostResIdl.data.postState.longValue();
            this.forumId = checkPostResIdl.data.forumId.longValue();
        }
    }
}
