package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.v;
import tbclient.FinishMemberTask.DataReq;
import tbclient.FinishMemberTask.FinishMemberTaskReqIdl;
/* loaded from: classes9.dex */
public class FinishMemberTaskReqMessage extends NetMessage {
    private long taskId;

    public void setTaskId(long j) {
        this.taskId = j;
    }

    public FinishMemberTaskReqMessage() {
        super(1003188, CmdConfigSocket.CMD_FINISH_MEMBER_TASK);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.task_id = Long.valueOf(this.taskId);
        if (z) {
            v.b(builder, true);
        }
        FinishMemberTaskReqIdl.Builder builder2 = new FinishMemberTaskReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
