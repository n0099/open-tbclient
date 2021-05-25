package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.AddTaskScores.AddTaskScoresReqIdl;
import tbclient.AddTaskScores.DataReq;
/* loaded from: classes3.dex */
public class GetTaskScoresRequestMessage extends NetMessage {
    public int taskId;
    public long userId;

    public GetTaskScoresRequestMessage() {
        super(CmdConfigHttp.CMD_GET_TASK_SCORES, 309367);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.task_id = Integer.valueOf(this.taskId);
        builder.user_id = Long.valueOf(this.userId);
        if (z) {
            w.a(builder, true);
        }
        AddTaskScoresReqIdl.Builder builder2 = new AddTaskScoresReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public int getTaskId() {
        return this.taskId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setTaskId(int i2) {
        this.taskId = i2;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
