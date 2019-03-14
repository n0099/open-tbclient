package com.baidu.tieba.square.forumlist;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.GetForumsFromForumClass.GetForumsFromForumClassResIdl;
/* loaded from: classes5.dex */
public class SquareForumListResSocketMsg extends SocketResponsedMessage {
    private GetForumsFromForumClassResIdl mResponseData;

    public SquareForumListResSocketMsg() {
        super(309097);
    }

    public GetForumsFromForumClassResIdl getResponseData() {
        return this.mResponseData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        this.mResponseData = (GetForumsFromForumClassResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumsFromForumClassResIdl.class);
        setError(this.mResponseData.error.errorno.intValue());
        setErrorString(this.mResponseData.error.usermsg);
    }
}
