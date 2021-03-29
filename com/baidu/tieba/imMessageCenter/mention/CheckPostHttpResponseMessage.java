package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CheckPost.CheckPostResIdl;
import tbclient.CheckPost.ResData;
/* loaded from: classes3.dex */
public class CheckPostHttpResponseMessage extends TbHttpResponsedMessage {
    public long forumId;
    public String forumName;
    public long postState;
    public long quoteId;
    public long repostId;

    public CheckPostHttpResponseMessage() {
        super(CmdConfigHttp.CMD_CHECK_POST);
    }

    public long getForumId() {
        return this.forumId;
    }

    public String getForumName() {
        return this.forumName;
    }

    public long getPostState() {
        return this.postState;
    }

    public long getQuoteId() {
        return this.quoteId;
    }

    public long getRepostId() {
        return this.repostId;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }

    public void setPostState(long j) {
        this.postState = j;
    }

    public void setQuoteId(long j) {
        this.quoteId = j;
    }

    public void setRepostId(long j) {
        this.repostId = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CheckPostResIdl checkPostResIdl = (CheckPostResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckPostResIdl.class);
        setError(checkPostResIdl.error.errorno.intValue());
        setErrorString(checkPostResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        this.postState = checkPostResIdl.data.postState.longValue();
        this.forumId = checkPostResIdl.data.forumId.longValue();
        ResData resData = checkPostResIdl.data;
        this.forumName = resData.fname;
        Long l = resData.quoteId;
        if (l != null) {
            this.quoteId = l.longValue();
        }
        Long l2 = checkPostResIdl.data.repostId;
        if (l2 != null) {
            this.repostId = l2.longValue();
        }
    }
}
