package com.baidu.tieba.pushdialog.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.GetLockWindowMsg.DataReq;
import tbclient.GetLockWindowMsg.GetLockWindowMsgReqIdl;
/* loaded from: classes5.dex */
public class PushDialogReqNetMsg extends NetMessage {
    public long task_id;
    public long tid;

    public PushDialogReqNetMsg() {
        super(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, 309614);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        try {
            DataReq.Builder builder = new DataReq.Builder();
            builder.tid = Long.valueOf(this.tid);
            builder.task_id = Long.valueOf(this.task_id);
            w.c(builder, true, true, true);
            GetLockWindowMsgReqIdl.Builder builder2 = new GetLockWindowMsgReqIdl.Builder();
            builder2.data = builder.build(true);
            return builder2.build(true);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void setTask_id(long j) {
        this.task_id = j;
    }

    public void setTid(long j) {
        this.tid = j;
    }
}
