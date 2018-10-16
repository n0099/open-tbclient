package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CheckPost.CheckPostResIdl;
/* loaded from: classes4.dex */
public class CheckPostResponseMessage extends SocketResponsedMessage {
    private long forumId;
    private String forumName;
    private long postState;
    private long quoteId;
    private long repostId;

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

    public long getQuoteId() {
        return this.quoteId;
    }

    public void setQuoteId(long j) {
        this.quoteId = j;
    }

    public long getRepostId() {
        return this.repostId;
    }

    public void setRepostId(long j) {
        this.repostId = j;
    }

    public String getForumName() {
        return this.forumName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CheckPostResIdl checkPostResIdl = (CheckPostResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckPostResIdl.class);
        setError(checkPostResIdl.error.errorno.intValue());
        setErrorString(checkPostResIdl.error.usermsg);
        if (getError() == 0) {
            this.postState = checkPostResIdl.data.postState.longValue();
            this.forumId = checkPostResIdl.data.forumId.longValue();
            this.forumName = checkPostResIdl.data.fname;
            if (checkPostResIdl.data.quoteId != null) {
                this.quoteId = checkPostResIdl.data.quoteId.longValue();
            }
            if (checkPostResIdl.data.repostId != null) {
                this.repostId = checkPostResIdl.data.repostId.longValue();
            }
        }
    }
}
