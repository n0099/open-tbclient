package com.baidu.tieba.pb.chosen.net;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.q;
import tbclient.ExcPbPage.DataReq;
import tbclient.ExcPbPage.ExcPbPageReqIdl;
/* loaded from: classes3.dex */
public class ChosenPbNetMessage extends NetMessage {
    public static final int QUALITY_HIGH = 80;
    public static final int QUALITY_LOW = 45;
    private long excId;
    private long q_type;
    private long scrH;
    private long scrW;
    private long scr_dip;
    private long tagCode;
    private long threadId;

    public void setTagCode(long j) {
        this.tagCode = j;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public ChosenPbNetMessage() {
        super(CmdConfigHttp.CMD_GET_FINE_PB, 309093);
    }

    public void setExcId(long j) {
        this.excId = j;
    }

    public void setScrH(long j) {
        this.scrH = j;
    }

    public void setScrW(long j) {
        this.scrW = j;
    }

    public void setScr_dip(long j) {
        this.scr_dip = j;
    }

    public void setQ_type(long j) {
        this.q_type = j;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.excid = Long.valueOf(this.excId);
        builder.q_type = Long.valueOf(this.q_type);
        builder.scr_h = Long.valueOf(this.scrH);
        builder.scr_w = Long.valueOf(this.scrW);
        builder.scr_dip = Long.valueOf(this.scr_dip);
        builder.tag_code = Long.valueOf(this.tagCode);
        builder.thread_id = Long.valueOf(this.threadId);
        q.bindCommonParamsToProtobufData(builder, true);
        ExcPbPageReqIdl.Builder builder2 = new ExcPbPageReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
