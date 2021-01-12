package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.GetMemberTaskList.DataReq;
import tbclient.GetMemberTaskList.GetMemberTaskListReqIdl;
/* loaded from: classes8.dex */
public class MemberTaskCenterRequestMessage extends NetMessage {
    public MemberTaskCenterRequestMessage() {
        super(1003187, CmdConfigSocket.CMD_MEMBER_TASK);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            t.b(builder, true);
        }
        GetMemberTaskListReqIdl.Builder builder2 = new GetMemberTaskListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
