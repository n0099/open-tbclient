package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.t;
import tbclient.DoDailyTask.DataReq;
import tbclient.DoDailyTask.DoDailyTaskReqIdl;
/* loaded from: classes9.dex */
public class DoDailyTaskRequestMessage extends NetMessage {
    private long taskId;
    private long userId;

    public DoDailyTaskRequestMessage() {
        super(1003173, CmdConfigSocket.CMD_DO_DAILY_TASK);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.task_id = Long.valueOf(this.taskId);
        builder.user_id = Long.valueOf(this.userId);
        if (z) {
            t.b(builder, true);
        }
        DoDailyTaskReqIdl.Builder builder2 = new DoDailyTaskReqIdl.Builder();
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

    public long getTaskId() {
        return this.taskId;
    }
}
