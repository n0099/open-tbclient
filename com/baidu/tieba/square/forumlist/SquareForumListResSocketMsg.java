package com.baidu.tieba.square.forumlist;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetForumsFromForumClass.GetForumsFromForumClassResIdl;
/* loaded from: classes5.dex */
public class SquareForumListResSocketMsg extends SocketResponsedMessage {
    public GetForumsFromForumClassResIdl mResponseData;

    public SquareForumListResSocketMsg() {
        super(309097);
    }

    public GetForumsFromForumClassResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetForumsFromForumClassResIdl getForumsFromForumClassResIdl = (GetForumsFromForumClassResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumsFromForumClassResIdl.class);
        this.mResponseData = getForumsFromForumClassResIdl;
        setError(getForumsFromForumClassResIdl.error.errorno.intValue());
        setErrorString(this.mResponseData.error.usermsg);
    }
}
