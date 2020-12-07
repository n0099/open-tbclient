package com.baidu.tieba.pb.chosen.net.zan;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.u;
import tbclient.ExcZan.DataReq;
import tbclient.ExcZan.ExcZanReqIdl;
/* loaded from: classes23.dex */
public class ChosenZanNetMessage extends NetMessage {
    private int action;
    private long excId;
    private long postId;
    private long threadId;

    public ChosenZanNetMessage() {
        super(1003007, CmdConfigSocket.CMD_CHOSEN_PB_PRAISE);
    }

    public void setExcId(long j) {
        this.excId = j;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public void setPostId(long j) {
        this.postId = j;
    }

    public void setAction(int i) {
        this.action = i;
    }

    public boolean isPraise() {
        return this.action == 1;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.action = Integer.valueOf(this.action);
        builder.excid = Long.valueOf(this.excId);
        builder.thread_id = Long.valueOf(this.threadId);
        builder.post_id = Long.valueOf(this.postId);
        u.a(builder, true);
        ExcZanReqIdl.Builder builder2 = new ExcZanReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
