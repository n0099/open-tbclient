package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.GetMemberTaskList.DataReq;
import tbclient.GetMemberTaskList.GetMemberTaskListReqIdl;
/* loaded from: classes3.dex */
public class MemberTaskCenterRequestMessage extends NetMessage {
    public MemberTaskCenterRequestMessage() {
        super(CmdConfigHttp.CMD_MEMBER_TASK, 309427);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            w.a(builder, true);
        }
        GetMemberTaskListReqIdl.Builder builder2 = new GetMemberTaskListReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
