package com.baidu.tieba.pb.chosen.net.zan;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.m0.z0.w;
import tbclient.ExcZan.DataReq;
import tbclient.ExcZan.ExcZanReqIdl;
/* loaded from: classes4.dex */
public class ChosenZanNetMessage extends NetMessage {
    public int action;
    public long excId;
    public long postId;
    public long threadId;

    public ChosenZanNetMessage() {
        super(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, 309095);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.action = Integer.valueOf(this.action);
        builder.excid = Long.valueOf(this.excId);
        builder.thread_id = Long.valueOf(this.threadId);
        builder.post_id = Long.valueOf(this.postId);
        w.a(builder, true);
        ExcZanReqIdl.Builder builder2 = new ExcZanReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public boolean isPraise() {
        return this.action == 1;
    }

    public void setAction(int i2) {
        this.action = i2;
    }

    public void setExcId(long j) {
        this.excId = j;
    }

    public void setPostId(long j) {
        this.postId = j;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }
}
