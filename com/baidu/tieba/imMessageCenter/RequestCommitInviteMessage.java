package com.baidu.tieba.imMessageCenter;

import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.CommitInviteMsg.CommitInviteMsgReqIdl;
import protobuf.CommitInviteMsg.DataReq;
/* loaded from: classes16.dex */
public class RequestCommitInviteMessage extends TbSocketMessage {
    private DataReq mReqData;

    public RequestCommitInviteMessage() {
        super(CmdConfigSocket.CMD_COMMIT_INVITE);
    }

    public void setReqData(DataReq dataReq) {
        this.mReqData = dataReq;
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        if (this.mReqData != null) {
            CommitInviteMsgReqIdl.Builder builder = new CommitInviteMsgReqIdl.Builder();
            builder.data = this.mReqData;
            return builder.build(false);
        }
        return null;
    }
}
