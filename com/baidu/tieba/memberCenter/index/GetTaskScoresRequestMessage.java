package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.AddTaskScores.AddTaskScoresReqIdl;
import tbclient.AddTaskScores.DataReq;
/* loaded from: classes8.dex */
public class GetTaskScoresRequestMessage extends NetMessage {
    private int taskId;
    private long userId;

    public GetTaskScoresRequestMessage() {
        super(1003101, CmdConfigSocket.CMD_GET_TASK_SCORES);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.task_id = Integer.valueOf(this.taskId);
        builder.user_id = Long.valueOf(this.userId);
        if (z) {
            t.b(builder, true);
        }
        AddTaskScoresReqIdl.Builder builder2 = new AddTaskScoresReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public void setTaskId(int i) {
        this.taskId = i;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getTaskId() {
        return this.taskId;
    }
}
