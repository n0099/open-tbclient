package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.z0.w;
import tbclient.DoDailyTask.DataReq;
import tbclient.DoDailyTask.DoDailyTaskReqIdl;
/* loaded from: classes3.dex */
public class DoDailyTaskRequestMessage extends NetMessage {
    public long taskId;
    public long userId;

    public DoDailyTaskRequestMessage() {
        super(CmdConfigHttp.CMD_DO_DAILY_TASK, 309405);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.task_id = Long.valueOf(this.taskId);
        builder.user_id = Long.valueOf(this.userId);
        if (z) {
            w.a(builder, true);
        }
        DoDailyTaskReqIdl.Builder builder2 = new DoDailyTaskReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public long getTaskId() {
        return this.taskId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setTaskId(int i) {
        this.taskId = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }
}
