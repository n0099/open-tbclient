package com.baidu.tieba.pb.chosen.net;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.h0.z0.w;
import tbclient.ExcPbPage.DataReq;
import tbclient.ExcPbPage.ExcPbPageReqIdl;
/* loaded from: classes4.dex */
public class ChosenPbNetMessage extends NetMessage {
    public static final int QUALITY_HIGH = 80;
    public static final int QUALITY_LOW = 45;
    public long excId;
    public long q_type;
    public long scrH;
    public long scrW;
    public long scr_dip;
    public long tagCode;
    public long threadId;

    public ChosenPbNetMessage() {
        super(CmdConfigHttp.CMD_GET_FINE_PB, 309093);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.excid = Long.valueOf(this.excId);
        builder.q_type = Long.valueOf(this.q_type);
        builder.scr_h = Long.valueOf(this.scrH);
        builder.scr_w = Long.valueOf(this.scrW);
        builder.scr_dip = Long.valueOf(this.scr_dip);
        builder.tag_code = Long.valueOf(this.tagCode);
        builder.thread_id = Long.valueOf(this.threadId);
        w.a(builder, true);
        ExcPbPageReqIdl.Builder builder2 = new ExcPbPageReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setExcId(long j) {
        this.excId = j;
    }

    public void setQ_type(long j) {
        this.q_type = j;
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

    public void setTagCode(long j) {
        this.tagCode = j;
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }
}
