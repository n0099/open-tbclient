package com.baidu.tieba.square.forumlist;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.GetForumsFromForumClass.GetForumsFromForumClassResIdl;
/* loaded from: classes17.dex */
public class SquareForumListResSocketMsg extends SocketResponsedMessage {
    private GetForumsFromForumClassResIdl mResponseData;

    public SquareForumListResSocketMsg() {
        super(CmdConfigSocket.CMD_SQUARE_FORUM_LIST);
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
