package com.baidu.tieba.personPolymeric.mode.message;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import tbclient.DeleteFriend.DeleteFriendReqIdl;
import tbclient.DeleteFriend.ReqData;
/* loaded from: classes9.dex */
public class RequestDeleteFriendMessage extends TbSocketMessage {
    private long friendId;

    public long getFriendId() {
        return this.friendId;
    }

    public void setFriendId(long j) {
        this.friendId = j;
    }

    public RequestDeleteFriendMessage() {
        super(CmdConfigSocket.CMD_DELETE_NEW_FRIEND);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        ReqData.Builder builder = new ReqData.Builder();
        builder.friend_id = Long.valueOf(getFriendId());
        DeleteFriendReqIdl.Builder builder2 = new DeleteFriendReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
