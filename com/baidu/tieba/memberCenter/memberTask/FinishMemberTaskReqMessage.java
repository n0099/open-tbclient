package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.z0.w;
import tbclient.FinishMemberTask.DataReq;
import tbclient.FinishMemberTask.FinishMemberTaskReqIdl;
/* loaded from: classes4.dex */
public class FinishMemberTaskReqMessage extends NetMessage {
    public long taskId;

    public FinishMemberTaskReqMessage() {
        super(CmdConfigHttp.CMD_FINISH_MEMBER_TASK, 309429);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.task_id = Long.valueOf(this.taskId);
        if (z) {
            w.a(builder, true);
        }
        FinishMemberTaskReqIdl.Builder builder2 = new FinishMemberTaskReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setTaskId(long j) {
        this.taskId = j;
    }
}
